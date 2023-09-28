import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String opcao = "";
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        while (!"0".equals(opcao)) {
            System.out.println("=============================================");
            System.out.println("1 - Incluir pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("=============================================");
            System.out.print("Digite a opção desejada: ");

            try {
                opcao = reader.readLine();

                switch (opcao) {
                    case "1":
                        System.out.println("1 - Pessoa Fisica | 2 - Pessoa Juridica");
                        String tipoPessoa = reader.readLine();
                        switch (tipoPessoa) {
                            case "1":
                                PessoaFisica pf = lerDadosPessoaFisica(reader);
                                repoFisica.inserir(pf);
                                System.out.println("((( Pessoa inserida com sucesso. )))");
                                break;
                            case "2":
                                PessoaJuridica pj = lerDadosPessoaJuridica(reader);
                                repoJuridica.inserir(pj);
                                System.out.println("((( Empresa inserida com sucesso. )))");
                                break;
                            default:
                                System.out.println("Tipo de pessoa inválido.");
                        }
                        break;

                    case "2":
                        System.out.println("1 - Pessoa Fisica | 2 - Pessoa Juridica");
                        String tipoPessoaAlterar = reader.readLine();
                        switch (tipoPessoaAlterar) {
                            case "1":
                                alterarPessoa(repoFisica, reader);
                                System.out.println("((( Pessoa alterada com sucesso. )))");
                                break;
                            case "2":
                                alterarPessoa(repoJuridica, reader);
                                System.out.println("((( Empresa alterada com sucesso. )))");
                                break;
                            default:
                                System.out.println("Tipo de pessoa inválido.");
                        }
                        break;

                    case "3":
                        System.out.println("1 - Pessoa Fisica | 2 - Pessoa Juridica");
                        String tipoPessoaExcluir = reader.readLine();
                        switch (tipoPessoaExcluir) {
                            case "1":
                                excluirPessoa(repoFisica, reader);
                                System.out.println("((( Pessoa excluída com sucesso. )))");
                                break;
                            case "2":
                                excluirPessoa(repoJuridica, reader);
                                System.out.println("((( Empresa excluída com sucesso. )))");
                                break;
                            default:
                                System.out.println("Tipo de pessoa inválido.");
                        }
                        break;

                    case "4":
                        System.out.println("1 - Pessoa Fisica | 2 - Pessoa Juridica");
                        String tipoPessoaBuscar = reader.readLine();
                        switch (tipoPessoaBuscar) {
                            case "1":
                                buscarPessoa(repoFisica, reader);
                                System.out.println("((( Pessoa encontrada com sucesso. )))");
                                break;
                            case "2":
                                buscarPessoa(repoJuridica, reader);
                                System.out.println("((( Empresa encontrada com sucesso. )))");
                                break;
                            default:
                                System.out.println("Tipo de pessoa inválido.");
                        }
                        break;

                    case "5":
                        System.out.println("1 - Pessoa Fisica | 2 - Pessoa Juridica");
                        String tipoPessoaExibirTodos = reader.readLine();
                        switch (tipoPessoaExibirTodos) {
                            case "1":
                                exibirTodasPessoas(repoFisica);
                                System.out.println("((( Pessoas encontradas )))");
                                break;
                            case "2":
                                exibirTodasPessoas(repoJuridica);
                                System.out.println("((( Empresas encontradas )))");
                                break;
                            default:
                                System.out.println("Tipo de pessoa inválido.");
                        }
                        break;

                    case "6":
                        System.out.print("Qual o prefixo dos arquivos: ");
                        String arquivoP = reader.readLine();
                        try {
                            repoFisica.persistir(arquivoP + ".fisica.bin");
                            repoJuridica.persistir(arquivoP + ".juridica.bin");
                            System.out.println("((( Dados salvos com sucesso. )))");
                        } catch (IOException e) {
                            System.out.println(" [X] Erro ao salvar os dados: " + e.getMessage());
                        }
                        break;

                    case "7":
                        System.out.print("Qual o prefixo dos arquivos: ");
                        String arquivoR = reader.readLine();
                        try {
                            repoFisica.recuperar(arquivoR + ".fisica.bin");
                            repoJuridica.recuperar(arquivoR + ".juridica.bin");
                            System.out.println("((( Dados recuperados com sucesso. )))");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println(" [X] Erro ao recuperar os dados: " + e.getMessage());
                        }
                        break;

                    case "0":
                        System.out.println("Fechando o sistema");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (IOException e) {
                System.out.println(" [X] Erro de entrada/saída: " + e.getMessage());
            }
        }
    }

    private static PessoaFisica lerDadosPessoaFisica(BufferedReader reader) throws IOException {
        System.out.print("Digite o Nome do usuário: ");
        String nome = reader.readLine();
        System.out.print("Digite o CPF do usuário: ");
        String cpf = reader.readLine();
        System.out.print("Digite a Idade do usuário: ");
        int idade = Integer.parseInt(reader.readLine());
        System.out.print("Digite o Id do usuário: ");
        int id = Integer.parseInt(reader.readLine());
        return new PessoaFisica(id, nome, cpf, idade);
    }

    private static PessoaJuridica lerDadosPessoaJuridica(BufferedReader reader) throws IOException {
        System.out.print("Digite o Nome da empresa: ");
        String nome = reader.readLine();
        System.out.print("Digite o CNPJ do usuário: ");
        String cnpj = reader.readLine();
        System.out.print("Digite o Id da empresa: ");
        int id = Integer.parseInt(reader.readLine());
        return new PessoaJuridica(id, nome, cnpj);
    }

    private static void alterarPessoa(Object repo, BufferedReader reader) throws IOException {
        System.out.print("Digite o Id que deseja alterar: ");
        int id = Integer.parseInt(reader.readLine());
        if (repo instanceof PessoaFisicaRepo) {
            PessoaFisica pf = ((PessoaFisicaRepo) repo).obter(id);
            if (pf != null) {
                System.out.println("CPF Antigo: " + pf.getCpf());
                System.out.print("Digite o novo CPF do usuário: ");
                pf.setCpf(reader.readLine());
                System.out.println("Idade Antiga: " + pf.getIdade());
                System.out.print("Digite a nova Idade do usuário: ");
                pf.setIdade(Integer.parseInt(reader.readLine()));
                System.out.println("Nome Antigo: " + pf.getNome());
                System.out.print("Digite o novo Nome do usuário: ");
                pf.setNome(reader.readLine());
                ((PessoaFisicaRepo) repo).alterar(pf);
                System.out.println("Pessoa alterada com sucesso.");
            } else {
                System.out.println("Pessoa não encontrada.");
            }
        } else if (repo instanceof PessoaJuridicaRepo) {
            PessoaJuridica pj = ((PessoaJuridicaRepo) repo).obter(id);
            if (pj != null) {
                System.out.println("CNPJ Antigo: " + pj.getCnpj());
                System.out.print("Digite o novo CNPJ do usuário: ");
                pj.setCnpj(reader.readLine());
                System.out.println("Nome Antigo: " + pj.getNome());
                System.out.print("Digite o novo Nome do usuário: ");
                pj.setNome(reader.readLine());
                ((PessoaJuridicaRepo) repo).alterar(pj);
                System.out.println("Pessoa alterada com sucesso.");
            } else {
                System.out.println("Pessoa não encontrada.");
            }
        }
    }

    private static void excluirPessoa(Object repo, BufferedReader reader) throws IOException {
        System.out.print("Digite o Id do usuário: ");
        int id = Integer.parseInt(reader.readLine());
        if (repo instanceof PessoaFisicaRepo) {
            ((PessoaFisicaRepo) repo).excluir(id);
            System.out.println("Pessoa excluída com sucesso.");
        } else if (repo instanceof PessoaJuridicaRepo) {
            ((PessoaJuridicaRepo) repo).excluir(id);
            System.out.println("Pessoa excluída com sucesso.");
        }
    }

    private static void buscarPessoa(Object repo, BufferedReader reader) throws IOException {
        System.out.print("Digite o Id do usuário: ");
        int id = Integer.parseInt(reader.readLine());
        if (repo instanceof PessoaFisicaRepo) {
            PessoaFisica pf = ((PessoaFisicaRepo) repo).obter(id);
            if (pf != null) {
                System.out.println("Id: " + pf.getId());
                System.out.println("CPF: " + pf.getCpf());
                System.out.println("Idade: " + pf.getIdade());
                System.out.println("Nome: " + pf.getNome());
            } else {
                System.out.println("Pessoa não encontrada.");
            }
        } else if (repo instanceof PessoaJuridicaRepo) {
            PessoaJuridica pj = ((PessoaJuridicaRepo) repo).obter(id);
            if (pj != null) {
                System.out.println("Id: " + pj.getId());
                System.out.println("CNPJ: " + pj.getCnpj());
                System.out.println("Nome: " + pj.getNome());
            } else {
                System.out.println("Pessoa não encontrada.");
            }
        }
    }

    private static void exibirTodasPessoas(Object repo) {
        if (repo instanceof PessoaFisicaRepo) {
            for (PessoaFisica pf : ((PessoaFisicaRepo) repo).obterTodos()) {
                System.out.println("id: " + pf.getId());
                System.out.println("Nome: " + pf.getNome());
                System.out.println("CPF: " + pf.getCpf());
            }
        } else if (repo instanceof PessoaJuridicaRepo) {
            for (PessoaJuridica pj : ((PessoaJuridicaRepo) repo).obterTodos()) {
                System.out.println("id: " + pj.getId());
                System.out.println("Nome: " + pj.getNome());
                System.out.println("CNPJ: " + pj.getCnpj());
            }
        }
    }
}
