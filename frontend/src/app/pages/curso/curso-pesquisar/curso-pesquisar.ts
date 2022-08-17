import { statusDaTurma } from "src/app/enumeracao/statusDaTurma";

export class CursoPesquisar {
    nomeCurso: string;
    duração: number;
    areaInteresse: string;
    linkdeCadastro: string;
    // tipoDeTurma: string;\\\\\\\
    // statusDaTurma: statusDaTurma;


    constructor(nomeCurso: string, duração: number, areaInteresse: string, linkdeCadastro: string) {

        this.nomeCurso = nomeCurso;
        this.duração = duração;
        this.areaInteresse = areaInteresse;
        this.linkdeCadastro = linkdeCadastro;
    
        }

}