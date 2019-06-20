package huawei.cloudbu.mock10;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileService {

    public void write(final String text){
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/wangchang.txt"));
            bw.write(text);
            bw.flush();
            System.out.println("content write sucessfully");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (bw != null){
                try{
                    bw.close();
                }catch (Exception e){

                }
            }
        }
    }
}
