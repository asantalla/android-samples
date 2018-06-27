package co.develoop.mtgcollector.arch.datasource

import org.joda.time.Period
import java.util.concurrent.TimeUnit

class CacheConfig(
        ttl: Int = 2,
        unit: TimeUnit = TimeUnit.MINUTES
) {
    val ttl: Period = when (unit) {
        TimeUnit.DAYS -> Period.days(ttl)
        TimeUnit.HOURS -> Period.hours(ttl)
        TimeUnit.MILLISECONDS -> Period.millis(ttl)
        TimeUnit.MINUTES -> Period.minutes(ttl)
        TimeUnit.SECONDS -> Period.seconds(ttl)
        else -> Period.hours(ttl)
    }
}