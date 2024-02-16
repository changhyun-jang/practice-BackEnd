package OOP.core.ticket;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

//    2차코드 - Audience 캡슐화
//    public Bag getBag(){
//        return bag;
//    }

    public Long buy(Ticket ticket){
//        3차코드 - Bag캡슐화
//        if(bag.hasInvitation()){
//            bag.setTicket(ticket);
//            return 0L;
//        } else {
//            bag.setTicket(ticket);
//            bag.minusAmount(ticket.getFee());
//            return ticket.getFee();
//        }
        return bag.hold(ticket);
    }
}
