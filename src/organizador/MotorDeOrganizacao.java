package organizador;

import java.io.File;
import java.nio.file.*;

public class MotorDeOrganizacao {

    private Path pastaDownloads;
    private Path pastaImagens;
    private Path pastaVideos;
    private Path pastaArquivos;
    private Path pastaCompactados;
    private Path pastaExecutaveis;

    public MotorDeOrganizacao(){
        String raizUsuario = System.getProperty("user.home");

        this.pastaDownloads = Paths.get(raizUsuario, "Downloads");

        this.pastaVideos = Paths.get(raizUsuario, "Videos", "Videos-Download");

        Path raizPessoal = Paths.get(raizUsuario);
        if (Files.exists(Paths.get(raizUsuario, "OneDrive"))){

            raizPessoal = Paths.get(raizUsuario, "OneDrive");

        }

        this.pastaImagens = raizPessoal.resolve("Pictures").resolve("Imagens-Download");
        this.pastaArquivos = raizPessoal.resolve("Documentos").resolve("Documentos-Download").resolve("Arquivo-Download");
        this.pastaCompactados = raizPessoal.resolve("Documentos").resolve("Documentos-Download").resolve("Compactado-Download");
        this.pastaExecutaveis = raizPessoal.resolve("Documentos").resolve("Documentos-Download").resolve("Executavel-Download");
    }

    public void iniciar(){
        System.out.println("Motor iniciado! Inspecionando pastas....");

        try {
            Files.createDirectories(this.pastaVideos);
            Files.createDirectories(this.pastaImagens);
            Files.createDirectories(this.pastaArquivos);
            Files.createDirectories(this.pastaCompactados);
            Files.createDirectories(this.pastaExecutaveis);

            try (DirectoryStream<Path> gaveta = Files.newDirectoryStream(this.pastaDownloads)) {
                for (Path arquivoAtual : gaveta) {
                    String nome = arquivoAtual.getFileName().toString().toLowerCase();

                    if (tentarMover(arquivoAtual, nome, this.pastaVideos, ".mp4", ".mkv", ".mov")){
                        continue;
                    }
                    if (tentarMover(arquivoAtual, nome, this.pastaImagens, ".jpg", ".jpeg", ".png", ".webp", ".gif")) {
                        continue;
                    }

                    if (tentarMover(arquivoAtual, nome, this.pastaArquivos, ".pdf", ".docx", ".txt", ".xlsx", ".pptx")) {
                        continue;
                    }

                    if (tentarMover(arquivoAtual, nome, this.pastaCompactados, ".zip", ".rar", ".7z")) {
                        continue;
                    }

                    if (tentarMover(arquivoAtual, nome, this.pastaExecutaveis, ".exe", ".msi", ".bat")) {
                        continue;
                    }
                }


            }
            System.out.println("Tudo Organizado.");

        } catch (Exception e){
            System.out.println("Erro critico: " + e.getMessage());
        }


    }

    private boolean tentarMover(Path arquivo, String nomeArquivo, Path pastaDestino, String... extensoes){

        for (String ext: extensoes){
            if (nomeArquivo.endsWith(ext)){
                try{
                    Path destinoFinal = pastaDestino.resolve(arquivo.getFileName());
                    Files.move(arquivo, destinoFinal, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Movido para " + pastaDestino.getFileName() + ": " + arquivo.getFileName());
                    return true;
                } catch (Exception e) {
                    System.out.println("Erro ao mover " + arquivo.getFileName() + ": " + e.getMessage());
                }
            }
        }
        return false;
    }

}
