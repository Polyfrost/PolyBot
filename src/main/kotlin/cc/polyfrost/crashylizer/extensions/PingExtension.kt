package cc.polyfrost.crashylizer.extensions

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import com.kotlindiscord.kord.extensions.utils.extraData
import dev.kord.core.behavior.interaction.followup.edit

class PingExtension : Extension() {
    override val name = "ping"

    override suspend fun setup() {
        publicSlashCommand {
            name = "ping"
            description = "pong"

            action {
                val response = respond {
                    content = "Ponging..."
                }

                response.edit {
                    val duration = response.message.timestamp - event.interaction.id.timestamp
                    content = """
                        Pong! :ping_pong:
                        Delay: ${duration.inWholeMilliseconds}ms
                        Gateway: ${event.gateway.ping.value!!.inWholeMilliseconds}ms
                    """.trimIndent()
                }
            }
        }
    }
}