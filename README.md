🗂️ Organizador de Downloads

Uma aplicação em Java com Interface Gráfica (GUI) para organizar de forma rápida e automática a sua pasta de Downloads.
O motor de organização inspeciona os seus ficheiros, identifica-os pela extensão e move-os para pastas devidamente categorizadas dentro dos seus diretórios principais (Imagens, Vídeos, Documentos, etc.), ajudando a manter o seu computador limpo e organizado.
✨ Funcionalidades

    Organização Automática Multiplataforma: Classifica os ficheiros em 5 categorias principais (agora com suporte nativo para os formatos mais comuns de Windows, macOS e Linux):

        🎬 Vídeos: .mp4, .mkv, .mov, .webm, .flv, .avi, .wmv, .qt

        🖼️ Imagens: .jpg, .jpeg, .png, .webp, .gif, .heic, .heif, .svg, .bmp, .tiff, .tif

        📄 Documentos: .pdf, .docx, .txt, .xlsx, .pptx, .md, .markdown, .odt, .ods, .odp, .rtf, .pages, .numbers, .key, .csv, .log

        📦 Compactados: .zip, .rar, .7z, .tar, .gz, .tar.gz, .tgz, .bz2, .tar.bz2, .xz, .tar.xz, .sitx

        ⚙️ Executáveis e Scripts: .exe, .msi, .bat, .dmg, .pkg, .app, .deb, .rpm, .appimage, .flatpak, .snap, .sh, .bash, .zsh, .py, .pl

    Interface Gráfica (GUI): Janela moderna e simples com um botão centralizado para iniciar a limpeza.

    Logs em Tempo Real: Acompanhe exatamente quais ficheiros estão a ser movidos ou se ocorreu algum erro (ex: ficheiros em uso).

    Multi-threading: O processo de mover os ficheiros ocorre em segundo plano, evitando que o ecrã bloqueie ou congele durante o processo.

    Compatibilidade com Nuvem: O programa deteta automaticamente se a sua pasta principal está sincronizada com o OneDrive (ou outros serviços) e ajusta os caminhos corretamente.

🛠️ Estrutura de Destino

Quando clica no botão para organizar, o programa move os ficheiros da pasta Downloads para as seguintes subpastas:

    \Videos\Videos-Download

    \Pictures\Imagens-Download

    \Documentos\Documentos-Download\Arquivo-Download

    \Documentos\Documentos-Download\Compactado-Download

    \Documentos\Documentos-Download\Executavel-Download

(As pastas são criadas automaticamente caso não existam).
💻 Tecnologias Utilizadas

    Linguagem: Java 8+

    Interface: Java Swing (JFrame, JButton, JTextArea)

    Manipulação de Ficheiros: Java NIO (java.nio.file.*)

🚀 Como Executar o Projeto
Pré-requisitos

Ter o Java Development Kit (JDK) instalado na máquina (versão 8 ou superior).
Executar via IDE (IntelliJ, Eclipse, VS Code)

    Clone ou transfira os ficheiros do projeto.

    Abra o projeto na sua IDE.

    Navegue até ao ficheiro OrganizadorGUI.java.

    Clique no botão de "Run" (Executar) ou utilize o atalho da IDE.
