# HabitTracker — Atividade Avaliativa

Projeto Android Studio em Kotlin + Jetpack Compose, baseado no guia de Navegação no Compose e adaptado para o tema **Diário de Treinos**.

## Estrutura
- `model/Habito.kt` e `model/Rota.kt`
- `viewmodel/HabitoViewModel.kt`
- `userinterface/Tema.kt`
- `userinterface/SplashScreen.kt`
- `userinterface/LoginScreen.kt`
- `userinterface/ListaHabitosScreen.kt`
- `userinterface/DetalheHabitoScreen.kt`
- `userinterface/EstatisticasScreen.kt`
- `userinterface/PerfilScreen.kt`
- `userinterface/PainelPrincipal.kt`
- `userinterface/AppNavigation.kt`
- `MainActivity.kt`

## Requisitos implementados
- Rotas type-safe com `sealed interface` + `@Serializable`.
- Splash com navegação condicional para Login ou Painel.
- Login e navegação linear.
- Passagem de `habitoId: Int` com `toRoute()`.
- Bottom Navigation com 3 abas.
- `saveState`, `restoreState` e `launchSingleTop`.
- Uma única instância de `HabitoViewModel` compartilhada.
- Tema próprio com `lightColorScheme`.
- Estados vazios e acessibilidade nos ícones.

## Como abrir
1. Extraia o ZIP.
2. Abra a pasta `HabitTracker` no Android Studio.
3. Aguarde o Gradle Sync.
4. Se o Android Studio pedir um SDK, instale/seleciona o Android SDK 35.
5. Execute em um emulador ou celular Android.

O login é propositalmente demonstrativo: qualquer e-mail/senha permite entrar, pois a atividade avalia principalmente navegação e arquitetura.
