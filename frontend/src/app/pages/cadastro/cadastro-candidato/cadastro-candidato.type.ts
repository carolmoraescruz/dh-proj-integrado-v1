import { TipoPCD } from "src/app/enumeracao/TipoPCD"

export type CadastroCandidato = {
    nome: string,
    sobrenome: string,
    cpf: string,
    dataNascimento: Date,
    tipoPCD: TipoPCD,
    email: string,
    senha: string,
    file?: File
}
