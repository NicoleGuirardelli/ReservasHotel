# Sistema de Reserva de Hotel

Este é um projeto acadêmico desenvolvido em Java que simula o funcionamento de um sistema de reservas de quartos, gerenciando o tipo, simples ou suíte de luxo, calculando a estadia e aplicando descontos referente a cada categoria.

## Aplicação
- Uso da interface *Reservavel* para garantir que qualquer tipo de quarto tenha métodos de reservar e cálculo de valor.
- Classe abstrata *Quarto* evita repetição de código e define comportamentos obrigatórios.
-  Cada tipo de quarto possui sua própria regra de *aplicarDesconto()*, polimorfismo.
- Regras de negócio, exceções para validar percentuais de desconto (máximo de 15% para simples e 30% para luxo).

