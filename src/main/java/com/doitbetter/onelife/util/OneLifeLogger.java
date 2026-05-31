package com.doitbetter.onelife.util;

import com.doitbetter.onelife.OneLife;
import org.slf4j.Logger;

public class OneLifeLogger {
    private static final Logger LOGGER = OneLife.LOGGER;
    private static int initStepCount = 0;

    // Enum representing internal mod states for easier runtime evaluation
    public enum LogState {
        SUCCESS,
        FAILURE,
        SKIPPED,
        CORRUPTED
    }

    // =========================================================================
    // INITIALIZATION PIPELINE TRACKING
    // =========================================================================

    /**
     * Executes a critical startup registration phase, logs a high-detail timeline,
     * and catches specific failures to isolate exactly where the initialization stack broke.
     *
     * @param stepName The name of the subsystem being initialized (e.g., "Block Registration")
     * @param initTask A method reference or lambda executing the registration code
     */
    public static void executeInitStep(String stepName, Runnable initTask) {
        initStepCount++;
        String prefix = String.format("[OneLife - INIT STEP %d] ", initStepCount);

        LOGGER.info("{}Starting phase: {}...", prefix, stepName);
        long startTime = System.currentTimeMillis();

        try {
            initTask.run();

            long duration = System.currentTimeMillis() - startTime;
            LOGGER.info("{}Successfully completed {} in {}ms.", prefix, stepName, duration);
        } catch (Exception e) {
            LOGGER.error("############################################################");
            LOGGER.error("{}CRITICAL CRASH OCCURRED DURING STARTUP SUBSYSTEM: {}!", prefix, stepName);
            LOGGER.error("{}This typically points to an illegal registry state or dependency order mismatch.", prefix);
            LOGGER.error("############################################################", e);

            throw new RuntimeException("OneLife failed to initialize during phase: " + stepName, e);
        }
    }

    // =========================================================================
    // RUNTIME RUN-STATE & COMPONENT LOGGING
    // =========================================================================

    /**
     * Intercepts standard vanilla loops, throws a detailed console warning,
     * and passes back the cancellation state. Perfect for compacting your Mixins.
     */
    public static boolean logAndIntercept(String system, String message, boolean shouldCancel) {
        if (shouldCancel) {
            LOGGER.warn("[OneLife - Overhaul] Intercepted and halted vanilla system [{}]: {}", system, message);
        }
        return shouldCancel;
    }
}