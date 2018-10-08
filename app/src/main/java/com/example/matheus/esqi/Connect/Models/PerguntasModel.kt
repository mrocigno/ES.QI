package com.example.matheus.esqi.Connect.Models

import java.io.Serializable


class PerguntasModel (id_pergunta: Int, titulo: String, data_cadastrado: String, pergunta: String, reposta_certa: String, reposta_errada1: String, reposta_errada2: String, reposta_errada3: String, fotoPath: String) : Serializable{
    var id_pergunta: Int = id_pergunta
    var titulo: String = titulo
    var data_cadastrado: String = data_cadastrado
    var pergunta: String = pergunta
    var reposta_certa: String = reposta_certa
    var reposta_errada1: String = reposta_errada1
    var reposta_errada2: String = reposta_errada2
    var reposta_errada3: String = reposta_errada3
    var fotoPath: String = fotoPath
}
