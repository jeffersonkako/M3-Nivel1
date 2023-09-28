import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class Main {
    public static void main(String[] args) throws Exception {

        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        PessoaFisica pessoa1 = new PessoaFisica(1, "João do Teste", "12333322200", 20);
        PessoaFisica pessoa2 = new PessoaFisica(2, "Maria do Teste", "12333322201", 21);
        repo1.inserir(pessoa1);
        repo1.inserir(pessoa2);

        repo1.persistir("dados-pf1");

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

        repo2.recuperar("dados-pf1");

        for (PessoaFisica pessoa : repo2.obterTodos()) {
            System.out.println("ID: " + pessoa.getId());
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("CPF: " + pessoa.getCpf());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println();
        }

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(1, "Jp Company", "12333322200000");
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(2, "Xpto Ltda", "12444000200001");
        repo3.inserir(pessoaJuridica1);
        repo3.inserir(pessoaJuridica2);

        repo3.persistir("dados-pj1");

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

        repo4.recuperar("dados-pj1");

        for (PessoaJuridica pessoaJuridica : repo4.obterTodos()) {
            System.out.println("Nome: " + pessoaJuridica.getNome());
            System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
            System.out.println();
        }
    }
}

