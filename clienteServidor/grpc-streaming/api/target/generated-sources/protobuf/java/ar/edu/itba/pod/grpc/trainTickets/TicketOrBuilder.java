// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trainTicketService/train_ticket_service.proto

package ar.edu.itba.pod.grpc.trainTickets;

public interface TicketOrBuilder extends
    // @@protoc_insertion_point(interface_extends:trainTicketService.Ticket)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string trainId = 2;</code>
   * @return The trainId.
   */
  java.lang.String getTrainId();
  /**
   * <code>string trainId = 2;</code>
   * @return The bytes for trainId.
   */
  com.google.protobuf.ByteString
      getTrainIdBytes();

  /**
   * <code>string passenger_name = 3;</code>
   * @return The passengerName.
   */
  java.lang.String getPassengerName();
  /**
   * <code>string passenger_name = 3;</code>
   * @return The bytes for passengerName.
   */
  com.google.protobuf.ByteString
      getPassengerNameBytes();
}
