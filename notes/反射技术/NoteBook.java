package cont;

public class NoteBook{
    /*
    *����
    */
    public static void run(){
        System.out.println("book run");
    }
    /*
     * ʹ��usb
    */
    void useUSB(USB usb){//��̬
        if(usb!=null){
            usb.open();
            usb.close();
        }
    }
}
