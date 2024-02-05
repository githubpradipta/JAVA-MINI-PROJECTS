package Video_Rental_Store;

class Video{
    String name;
    boolean checked;
    double rating;
    public Video(String name){
        this.name = name;
        this.checked = false;
        this.rating = 0.0f; 
    }
    String getName(){
        return this.name;
    } 
    boolean isChecked(){
        return this.checked;
    }
    double getRating(){
        return this.rating;
    }
    public void check(){
        this.checked=true;
    }
    public void returnVideo(){
        this.checked=false;
    }
    public void giveRating(double rating){
        this.rating= rating;
    }
}

class Store{
    private Video[] inventory;
    public Store(){
        this.inventory = new Video[10];
    }

    public void addVideo(String name){
       for(int i=0;i<inventory.length;i++){
            if(inventory[i]==null){
                inventory[i]=new Video(name);
                break;
            }
       }
    }
    public void checkOut(String name){
        for(Video x: inventory){
            if(x.name==name && !x.checked){
                x.check();
                break;
            }
        }
    }
    public void returnVideo(String name){
        for(Video x:inventory){
            if(x.name==name && x.checked){
                x.returnVideo();
                break;
            }
        }
    }
    public void receiveRating(String name,double rating){
        for(Video x:inventory){
            if(x.name==name){
                x.giveRating(rating);
                break;
            }
        }
    }
    public void listInventory(){
        for(Video x:inventory){
            if(x!=null){  
                      System.out.println("Title: " + x.getName() +
                        ", Availablity: " + (x.isChecked()?("Rented"):("Available")) +
                        ", Average Rating: " + x.getRating()+"\n");
            }     
        }
    }

}

public class VideoStore {
    public static void main(String[] args) {
        Store store_1 = new Store();
        store_1.addVideo("Jawan");
        store_1.addVideo("Traveller");
        store_1.addVideo("Dunkey");
        store_1.receiveRating("Jawan", 5.1);
        store_1.receiveRating("Traveller", 4.5);
        store_1.receiveRating("Dunkey", 6.4);
        store_1.checkOut("Jawan");
        store_1.listInventory();
        store_1.returnVideo("Jawan");
        System.out.println("---------------------------------\n");
        store_1.listInventory();
        

    }
}
