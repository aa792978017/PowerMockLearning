package huawei.cloudbu.mock1to4.service.mock10;

import huawei.cloudbu.mock10.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
public class FileServiceTest {

    @Test
    public void testWrite(){
        FileService fileService = PowerMockito.mock(FileService.class);
        fileService.write("liudeihua"); //假的对象，没有生成文本文件
    }

    @Test
    public void testWriteSpy() {
        FileService fileService = PowerMockito.spy(new FileService());
        fileService.write("liudeihua");
        File file = new File(System.getProperty("user.dir") + "/wangchang.txt");
        assertTrue(file.exists());

    }

}
