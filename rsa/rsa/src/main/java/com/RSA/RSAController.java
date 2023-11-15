package com.RSA;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/demo-controller")
public class RSAController {

  @Autowired
  private EncryptDecryptService encryptDecryptService;
  @GetMapping("/createkey")
  public void privatePublicKey() {
encryptDecryptService.createKey();
  }

//  String textEncryption;

  @PostMapping("/encrypt")
  public String encryptMsg(@RequestBody String plainText){
    //    log.info("test : " + plainText.toString());
//    textEncryption = plainText.toString();
    return encryptDecryptService.encryptMsg(plainText);
  }
  @PostMapping("/decrypt")
  public String decryptMsg(@RequestBody String encryptString ,@RequestHeader(value = "encryptedText") String encryptedText){

    if (encryptedText.equals(encryptDecryptService.decryptMsg(encryptString)) ){
      return encryptDecryptService.decryptMsg(encryptString);
    }
return "any other person doing something with this";
  }


}
