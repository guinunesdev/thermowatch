# **ThermoWatch**

**ThermoWatch** é uma aplicação desktop desenvolvida em Kotlin com JavaFX, que permite monitorar em tempo real a temperatura da CPU e GPU, bem como o uso da CPU. O objetivo é fornecer uma visualização simples e clara sobre o desempenho térmico e de uso do sistema, com gráficos dinâmicos e atualizações frequentes.
Projeto desenvolvido a fins de estudos (Com base no avanço do meu conhecimento em Kotlin/JavaFX).

## **Funcionalidades**

- **Monitoramento de Temperatura da CPU**: Exibe a temperatura atual da CPU em graus Celsius.
- **Monitoramento de Temperatura da GPU**: Exibe a temperatura da GPU (caso disponível) em graus Celsius.
- **Uso da CPU**: Exibe a porcentagem de uso atual da CPU.
- **Gráficos Interativos**: Mostra gráficos em tempo real para o uso da CPU e temperaturas da CPU e GPU.
- **Atualização Automática**: As informações são atualizadas a cada segundo para fornecer dados em tempo real.

## **Tecnologias Utilizadas**

- **Kotlin**: Linguagem de programação moderna para aplicações JVM.
- **JavaFX**: Framework utilizado para criar interfaces gráficas (GUI).
- **SystemMonitor**: Classe personalizada para obter dados do sistema, como uso da CPU e temperaturas.
- **Timer Kotlin**: Para obter dados de forma periódica e atualizá-los a cada segundo.

## **Requisitos**

- **JDK 11 ou superior**: Requer o Java Development Kit (JDK) 11 ou superior para compilar e executar o projeto.
- **Gradle**: Sistema de build usado para gerenciar dependências e a construção do projeto.
- **JavaFX**: Biblioteca para criar interfaces gráficas.

## **Como Rodar**

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seuusuario/thermowatch.git
   ```

2. **Abra o projeto em um editor Kotlin/IntelliJ IDEA**.

3. **Instale o Gradle** (caso não tenha):
   - Siga as instruções de instalação do Gradle [aqui](https://gradle.org/install/).

4. **Execute a aplicação**:
   - No IntelliJ, basta clicar em "Run" para rodar a aplicação.

5. **Alternativamente, pelo terminal**:
   - Vá até o diretório do projeto e execute o comando:
   ```bash
   ./gradlew run
   ```

## **Como Contribuir**

1. Faça um fork deste repositório.
2. Crie uma branch para sua feature (`git checkout -b minha-feature`).
3. Faça as alterações desejadas.
4. Commit e push (`git commit -am 'Adiciona nova funcionalidade'` e `git push origin minha-feature`).
5. Abra um Pull Request explicando as modificações.
