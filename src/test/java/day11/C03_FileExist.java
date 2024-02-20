package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void isExistTest() {
        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);//C:\SeleniumBatch81\com.B103Maven_Junit

        String userHome = System.getProperty("user.home");
        System.out.println(userHome);//C:\Users\SENA

        //logo.jpeg indirip masaustune kaydedin
        //Logo masaustunde :C:\Users\SENA\Desktop

        String dosyaYolu = userHome + "/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);

        boolean isExist = Files.exists(Paths.get(dosyaYolu));//dosya var ise true yoksa false verecek
        Assert.assertTrue(isExist);
        /*
    1.fail   ->    PATH YANLIS : dosya massaustunde degil, dosya adı yanlıs, ya da onedrive gibi ex dosyalar olar
         */


    }
}
