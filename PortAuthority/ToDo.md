- JMS Resources (Per GlassFish install)
    - [ ] The MessageFactory
        - one for the entire project
    - [ ] The Queue
        - for NoticeManager to send messages to Port Authority 
    - [ ] Topic resources [2x AgentOne & AgentTwo]
        - [ ] for PortAuthority to publish messages
        - [ ] publish to the agents
- Backing Beans (client)
    - [ ] add necessary fields and methods
    - [ ] NoticeManager class
        - [ ] serialize current NoticeOfArrival object into JASON string
        - [ ] use JSON string as the content of TextMessage to the Queue from above
    - [ ] Add missing bindings in NoticeOfArrival.xhtml
        - [ ] each input field should refer to it's counterpart in the backing object (Notice of Arrival)
        - [ ] commandButton element should bind to NoticeManager method that send message to PortAuthority
- Business beans (receiving end)
    - [ ] Implement PortAuthority Message Driven Bean [MDB] and methods
        - [ ] read notice of arrival from the queue (in JSON) (see https://javaee.github.io/tutorial/jsonp.html)
        - [ ] deserialize into NoticeOfArrival object (see https://a7746-3729332.cluster207.canvas-user-content.com/courses/7746~82936/files/7746~3729332/course%20files/3_port_authority/javaships.zip)
        - [ ] Use EntityManager (inject Enterprise JavaBeans [EJB]) to save this object into NoticeOfArrival table in database (PortAuthority) (see week 6 slides for JPA)
        - [ ] publish message to one of the two JMS Topics
        - [ ] Implement agent MDBs