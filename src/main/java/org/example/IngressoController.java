package org.example;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class IngressoController {
    public static void calcular(HttpExchange troca) throws IOException{
        if(!troca.getRequestURI().getPath().equals("/api/ingressos")){
            responder(troca, 404, "{\"erro\":\"Rota não encontrada.\"}");
            return;
        }
        if(!troca.getRequestMethod().equals("POST")){
            troca.getResponseHeaders().set("Allow", "POST");
            responder(troca, 405, "{\"erro\":\"Utilize POST para calcular.\"}");
            return;
        }
    }
}
