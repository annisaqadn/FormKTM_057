/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSA.project.formKTM;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fuadi
 */
@Controller
public class myController {
    @RequestMapping("/data")
    public String getData(@RequestParam("varNama")String textNama,
                          @RequestParam("varNIM")String textNIM,
                          @RequestParam("varTL")@DateTimeFormat(pattern="yyyy-MM-dd")Date date,
                          @RequestParam("varPS")String textPS,
                          @RequestParam("varE")String textE,
                          @RequestParam("varFoto")MultipartFile foto,
            Model kurir) throws IOException{
        SimpleDateFormat tanggal = new SimpleDateFormat("dd MMMM yyyy");
        String tanggalLahir = tanggal.format(date);
        
        String blob = Base64.encodeBase64String(foto.getBytes());
        String fotoKTM ="data:image/*;base64,".concat(blob);
        
        kurir.addAttribute("paket1", textNama);
        kurir.addAttribute("paket2", textNIM);
        kurir.addAttribute("paket3", tanggalLahir);
        kurir.addAttribute("paket4", textPS);
        kurir.addAttribute("paket6", textE);
        kurir.addAttribute("paket5", fotoKTM);
        
        return "viewpage";
    }
}
