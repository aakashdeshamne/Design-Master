package Challange5.Entity;

public class InternalRequest extends Request {
    public InternalRequest(int floor) {
        super(floor);

    }
    
    @Override
    public RequestType getType() {
        return RequestType.INTERNAL;
    }
    
}
