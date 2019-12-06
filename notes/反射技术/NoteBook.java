package cont;

public class NoteBook{
    /*
    *运行
    */
    public static void run(){
        System.out.println("book run");
    }
    /*
     * 使用usb
    */
    void useUSB(USB usb){//多态
        if(usb!=null){
            usb.open();
            usb.close();
        }
    }
}
