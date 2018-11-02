package com.example.matheus.esqi.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.matheus.esqi.R
import kotlinx.android.synthetic.main.activity_material.*

class MaterialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)

        material_imgBack.setOnClickListener {
            onBackPressed()
        }

        val summary = "" +
                "<html>\n" +
                "    <body>\n" +
                "        \n" +
                "        <h2>Links úteis:</h2>\n" +
                "        <ul>\n" +
                "            <li>\n" +
                "                <a href=\"https://www.infoescola.com/engenharia-de-software/rup/\">RUP</a>\n" +
                "            </li>\n" +
                "            \n" +
                "            <li>\n" +
                "                <a href=\"https://www.ateomomento.com.br/o-que-e-requisito-funcional/\">Requisitos funcionais</a>\n" +
                "            </li>\n" +
                "            \n" +
                "            <li>\n" +
                "                <a href=\"https://www.devmedia.com.br/artigo-engenharia-de-software-3-requisitos-nao-funcionais/9525\">Requisitos não funcionais</a>\n" +
                "            </li>\n" +
                "            \n" +
                "            <li>\n" +
                "                <a href=\"https://www.devmedia.com.br/ciclos-de-vida-do-software/21099\">Ciclos de Vida do Software</a>\n" +
                "            </li>\n" +
                "            \n" +
                "            <li>\n" +
                "                <a href=\"https://casadaconsultoria.com.br/modelo-cascata/\">Modelo Cascata: O que é e como funciona?</a>\n" +
                "            </li>\n" +
                "            \n" +
                "            <li>\n" +
                "                <a href=\"https://guiadoestudante.abril.com.br/profissoes/engenharia-de-software/\">Engenharia de Software</a>\n" +
                "            </li>\n" +
                "            \n" +
                "            <li>\n" +
                "                <a href=\"https://www.tiespecialistas.com.br/a-evolucao-do-software/\">A evolução do Software</a>\n" +
                "            </li>\n" +
                "            \n" +
                "        </ul> <       \n" +
                "        <center>\n" +
                "            <h1>Manutenção</h1>\n" +
                "       </center>\n" +
                "        <ul>\n" +
                "            <li style=\"text-align: justify;\">\n" +
                "                A mais de três décadas, a manutenção de software foi caracterizada como um “iceberg” [CAN72];\n" +
                "            </li>\n" +
                "        \n" +
                "            <li style=\"text-align: justify;\">\n" +
                "                Esperamos que o imediatamente visível seja tudo o que existe, mas sabemos que uma enorme massa de possíveis problemas e custo fica sob a superfície;\n" +
                "            </li>\n" +
                "            \n" +
                "            <li style=\"text-align: justify;\">\n" +
                "                A manutenção de software existente pode ser responsável por mais de 60% de todo o esforço despendido por uma organização de desenvolvimento. [PRE06]\n" +
                "            </li>\n" +
                "        </ul>\n" +
                "        \n" +
                "        <center>\n" +
                "            <h1>Tipos de manutenção</h1>\n" +
                "        </center>\n" +
                "        <ul>\n" +
                "            <li style=\"text-align: justify;\">\n" +
                "                <h2>Manuteção corretiva</h2>        \n" +
                "                <ul>\n" +
                "                    <li>\n" +
                "                        Deficiência;\n" +
                "                    </li>\n" +
                "                    <li style=\"text-align: justify;\">\n" +
                "                        Tem por sua finalidade corrigir alguma coisa no sistema, seja algum bug ou um botão no lugar errado.\n" +
                "                    </li>\n" +
                "                </ul>\n" +
                "            </li>\n" +
                "            \n" +
                "            <li style=\"text-align: justify;\">\n" +
                "                <h2>Manuteção Adaptativa</h2>        \n" +
                "                <ul>\n" +
                "                    <li>\n" +
                "                        Mudança de Ambiente;\n" +
                "                    </li>\n" +
                "                    <li style=\"text-align: justify;\">\n" +
                "                        Tem por sua finalidade se adequar a alguma coisa, seja por uma nova lei ou um novo processo que afeta o uso do sistema.\n" +
                "                    </li>\n" +
                "                </ul>\n" +
                "            </li>\n" +
                "            \n" +
                "            <li style=\"text-align: justify;\">\n" +
                "                <h2>Manuteção Aperfeiçoadora</h2>        \n" +
                "                <ul>\n" +
                "                    <li>\n" +
                "                        Requisição de manutenção do usuário;\n" +
                "                    </li>\n" +
                "                    <li style=\"text-align: justify;\">\n" +
                "                        Tem por sua finalidade melhorar alguma coisa no sistema. Esse tipo de manutenção também pode ser descrito como \"Manuteção de Melhorias\"\n" +
                "                    </li>\n" +
                "                </ul>\n" +
                "            </li>\n" +
                "            \n" +
                "            <li style=\"text-align: justify;\">\n" +
                "                <h2>Manuteção Preventiva</h2>        \n" +
                "                <ul>\n" +
                "                    <li>\n" +
                "                        Prevenir futuras manutenções;\n" +
                "                    </li>\n" +
                "                    <li style=\"text-align: justify;\">\n" +
                "                        Tem por sua finalidade evitar futuros erros a partir de eventos já conhecidos\n" +
                "                    </li>\n" +
                "                </ul>\n" +
                "            </li>\n" +
                "            \n" +
                "        </ul>\n" +
                "        \n" +
                "        <center>\n" +
                "            <h1>Reengenharia</h1>\n" +
                "        </center>\n" +
                "        \n" +
                "        <ul>\n" +
                "            <li style=\"text-align: justify;\">\n" +
                "                Michel Hammer lançou as fundações de uma revolução no modo de pensar gerencial a respeito de processos do negócio e computação;\n" +
                "            </li>\n" +
                "            \n" +
                "            <li style=\"text-align: justify;\">\n" +
                "                Já é hora de parar de pavimentar trilhas de gado. Em vez de embutir processos desatualizados em silício e software, deveríamos descartá-los e começar de novo. Deveríamos “reengenheirar” os nossos processos de negócio a fim de conseguir aperfeiçoamentos drásticos em seu desempenho.\n" +
                "      <li>    <li style=\"text-align: justify;\">\n" +
                "                Toda empresa opera sob muitas regras desarticuladas... A reengenharia procura romper com as antigas regras sobre a condução e a organização do negócio.\n" +
                "            </li>\n" +
                "            \n" +
                "        </ul>\n" +
                "    </body>\n" +
                "</html>"
        webview.loadData(summary, "text/html; charset=utf-8", "utf-8")
    }
}
