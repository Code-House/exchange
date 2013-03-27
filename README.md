# Code-House Exchange library

Abstract concept of new API for messaging - nothing sure. Placeholder for experimental work.

## Important changes

* No IN/OUT messages
* Producer and Consumer renamed to Publisher and Receiver
* Different message types
* No difference between exchange properties and headers - both are named properties

### NO IN/OUT messages
Existence of IN/OUT messages at the same time is very confusing for users. For most of them OUT message is not used at all. Because of this we decided to let our exchange transfer only one message instance at same time. It's up to Endpoint to decide what to do with Message which remains in Exchange - depends on Exchange Pattern used.

### Producer and Consumer renamed
Producer and Consumer are terminology borrowed from JMS specification. It's good enought however it does not reflect all cases. It's not conflicted with *Enterprise Integration Patterns* - you still may implement PollingConsumer, the only one difference is that you will implement Publisher interface first. How you name your classes is up to you.

### Different message types
There are couple types of data strucutes used by this exchange api:
* Frame - baisc element with body and properties - does not support conversion
* Frames - ordered list of frames
* Message - an extension of Frames which allows to conver payload and access all frame properties at the same time - its composite frame from technology point of view.
* MultipartMessage - messge which have list of bodies (it may be MimeMessage for example or SoapMessage with multiple parts)

### Exchange and Message properties
The most common term is headers. We need to think here, since Exchange has no headers but properties. So far everything is named as property and base type for Frame/Message/Exchange is PropertiesHolder. The name is not lucky, lookging for another name.
