package it.nexoapp.evt.config;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

/**
 * Events microservice settings, mapped from configuration properties with the {@code evt} prefix.
 * <p>
 * Every property is optional and falls back to a default when not set.
 */
@StaticInitSafe
@ConfigMapping(prefix = "evt")
public interface EventsConfig {

    /**
     * Messaging settings (properties with the {@code evt.messaging} prefix).
     */
    Messaging messaging();

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Settings of the event messaging, mapped from the {@code evt.messaging} prefix.
     */
    interface Messaging {

        /**
         * Name of the topic exchange the outbox relay publishes this service's events on
         * (property {@code evt.messaging.exchange}). Optional, defaults to {@code nexo.evt}.
         */
        @WithDefault("nexo.evt")
        String exchange();

    }

}
