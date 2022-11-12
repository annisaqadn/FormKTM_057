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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fuadi
 */
@Controller
public class myController {
    @RequestMapping("/data")
    @ResponseBody
    public String getData(@RequestParam("varNama")String textNama,
                          @RequestParam("varNIM")String texNIM,
                          @RequestParam("varTL")@DateTimeFormat(pattern="yyyy-MM-dd")Date date,
                          @RequestParam("varPS")String textPS,
                          @RequestParam("varFoto")MultipartFile foto)
            throws IOException{
        SimpleDateFormat tanggal = new SimpleDateFormat("EEEE-dd-MMMM-yyyy");
        String tanggalLahir = tanggal.format(date);
        
        String blob = Base64.encodeBase64String(foto.getBytes());
        
        return "<br> <img src='data:image/*;base64,"+blob+"' /><br>"+tanggalLahir;
    }
}
