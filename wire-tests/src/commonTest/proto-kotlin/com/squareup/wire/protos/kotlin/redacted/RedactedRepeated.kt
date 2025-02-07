// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: redacted_test.proto
package com.squareup.wire.protos.kotlin.redacted

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.WireField
import com.squareup.wire.internal.redactElements
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

class RedactedRepeated(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.REPEATED,
    redacted = true
  )
  val a: List<String> = emptyList(),
  /**
   * Values in the repeated type need redacting.
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.protos.kotlin.redacted.Redacted#ADAPTER",
    label = WireField.Label.REPEATED
  )
  val b: List<Redacted> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<RedactedRepeated, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing {
    throw AssertionError()
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is RedactedRepeated) return false
    return unknownFields == other.unknownFields
        && a == other.a
        && b == other.b
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + a.hashCode()
      result = result * 37 + b.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (a.isNotEmpty()) result += """a=██"""
    if (b.isNotEmpty()) result += """b=$b"""
    return result.joinToString(prefix = "RedactedRepeated{", separator = ", ", postfix = "}")
  }

  fun copy(
    a: List<String> = this.a,
    b: List<Redacted> = this.b,
    unknownFields: ByteString = this.unknownFields
  ): RedactedRepeated = RedactedRepeated(a, b, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<RedactedRepeated> = object : ProtoAdapter<RedactedRepeated>(
      FieldEncoding.LENGTH_DELIMITED, 
      RedactedRepeated::class
    ) {
      override fun encodedSize(value: RedactedRepeated): Int = 
        ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, value.a) +
        Redacted.ADAPTER.asRepeated().encodedSizeWithTag(2, value.b) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: RedactedRepeated) {
        ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 1, value.a)
        Redacted.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.b)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): RedactedRepeated {
        val a = mutableListOf<String>()
        val b = mutableListOf<Redacted>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> a.add(ProtoAdapter.STRING.decode(reader))
            2 -> b.add(Redacted.ADAPTER.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return RedactedRepeated(
          a = a,
          b = b,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: RedactedRepeated): RedactedRepeated = value.copy(
        a = emptyList(),
        b = value.b.redactElements(Redacted.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
