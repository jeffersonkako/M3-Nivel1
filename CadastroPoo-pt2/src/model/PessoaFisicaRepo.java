
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo {
    private final List<PessoaFisica> listaPessoasFisicas = new ArrayList<>();

    public void inserir(PessoaFisica pessoaFisica) {
        listaPessoasFisicas.add(pessoaFisica);
    }

    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < listaPessoasFisicas.size(); i++) {
            if (pessoaFisica.getId() == listaPessoasFisicas.get(i).getId()) {
                listaPessoasFisicas.set(i, pessoaFisica);
                return;
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < listaPessoasFisicas.size(); i++) {
            if (listaPessoasFisicas.get(i).getId() == id) {
                listaPessoasFisicas.remove(i);
                return;
            }
        }
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : listaPessoasFisicas) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }
        return null;
    }

    public List<PessoaFisica> obterTodos() {
        return listaPessoasFisicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(listaPessoasFisicas);
        } catch (IOException e) {
            throw e;
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoasFisicas.clear();
            List<PessoaFisica> listaRecuperada = (List<PessoaFisica>) inputStream.readObject();
            listaPessoasFisicas.addAll(listaRecuperada);
        } catch (IOException | ClassNotFoundException e) {
            throw e;
        }
    }
}
