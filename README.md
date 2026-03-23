<h1>🎬 Films — Приложение для поиска фильмов на Jetpack Compose</h1>

<p>
Android-приложение для поиска фильмов, переписанное с классического View-подхода на <b>Jetpack Compose</b>.<br>
Проект создан для изучения декларативного UI и сравнения двух подходов: XML vs Compose.<br>
Демонстрирует работу с Clean Architecture, MVVM, REST API и современными подходами к управлению состоянием.
</p>

<h2>🚀 Основной функционал</h2>
<ul>
  <li><b>Поиск фильмов</b> — ввод названия с debounce-защитой от частых запросов</li>
  <li><b>Детали фильма</b> — просмотр постера, названия и описания фильма</li>
  <li><b>Навигация</b> — переход между экранами через Navigation Compose</li>
  <li><b>Состояния UI</b> — обработка initial / loading / success / error / empty</li>
  <li><b>Material Design 3</b> — современный интерфейс с кастомной темой</li>
</ul>

<h2>🛠 Технологии и библиотеки</h2>

<h3>Язык и платформа</h3>
<ul>
  <li>Kotlin — основной язык разработки</li>
  <li>Android SDK (minSdk 24, targetSdk 36, compileSdk 36)</li>
  <li>Java 11</li>
</ul>

<h3>Архитектура</h3>
<ul>
  <li>Clean Architecture — разделение на слои: data / domain / presentation</li>
  <li>MVVM — разделение логики и UI</li>
  <li>Repository Pattern — абстракция источников данных</li>
  <li><b>Unidirectional Data Flow (UDF)</b> — однонаправленный поток данных в UI</li>
</ul>

<h3>Основные библиотеки</h3>
<ul>
  <li>Koin — Dependency Injection</li>
  <li>Retrofit 2 — работа с API</li>
  <li>Gson — парсинг JSON</li>
  <li>AndroidX Lifecycle — ViewModel, StateFlow, SharedFlow</li>
  <li><b>Navigation Compose</b> — навигация на основе Compose</li>
  <li><b>Jetpack Compose</b> — декларативный UI</li>
  <li><b>Glide Compose</b> — загрузка изображений</li>
  <li>Kotlinx Serialization — сериализация для маршрутов навигации</li>
  <li>Material 3 — UI-компоненты</li>
  <li>ConstraintLayout Compose — гибкая вёрстка</li>
</ul>

<h2>Jetpack Compose в проекте</h2>

<p>
Проект демонстрирует переход от XML к Jetpack Compose и использование современных подходов:
</p>

<ul>
  <li>Декларативный UI</li>
  <li>Unidirectional Data Flow</li>
  <li>StateFlow + collectAsState</li>
  <li>Navigation Compose</li>
</ul>

<h2>🆚 Отличия от XML (View-based) версии</h2>
<p>
Проект является переработкой классического Android-приложения (APItest) на Jetpack Compose.
</p>
<ul>
  <li>Полный отказ от XML-разметки</li>
  <li>UI описывается через @Composable функции</li>
  <li>Состояние управляется через StateFlow вместо LiveData</li>
  <li>Навигация реализована через Navigation Compose с типобезопасными маршрутами</li>
  <li>Меньше boilerplate-кода, более читаемые компоненты</li>
</ul>

<h2>🏗 Архитектурные подходы</h2>

<h3>Слои приложения</h3>

<p><b>Data Layer</b> — работа с API и преобразование данных.</p>
<ul>
  <li>FilmApi — Retrofit-интерфейс для запросов к API</li>
  <li>FilmRemoteRepositoryImpl — реализация репозитория</li>
  <li>DTO — модели API (FilmResponse, FilmDescriptionDto)</li>
  <li>NetworkClient — HTTP-клиент на Retrofit</li>
</ul>

<p><b>Domain Layer</b> — бизнес-логика приложения.</p>
<ul>
  <li>Interactor — сценарии использования (SearchFilmsDescriptionInteractor)</li>
  <li>Repository — интерфейсы репозиториев (FilmRemoteRepository)</li>
  <li>Domain Models — модели (FilmDescription)</li>
</ul>

<p><b>Presentation Layer</b> — UI и взаимодействие с пользователем.</p>
<ul>
  <li>ViewModel — управление состоянием (FilmsViewModel, PosterViewModel)</li>
  <li>Composable Screens — экраны (FilmListScreen, FilmDetailsScreen)</li>
  <li>UiState — состояния UI (Initial, Loading, Content, Error, Empty)</li>
  <li>UiEvent — события UI (ShowToast)</li>
  <li>Components — переиспользуемые Composable-компоненты</li>
</ul>

<h3>Ключевые паттерны</h3>
<ul>
  <li>Debounce — защита от частых запросов поиска (2000 мс)</li>
  <li>StateFlow / SharedFlow — реактивные потоки данных</li>
  <li>Observer Pattern — обновление UI через StateFlow</li>
  <li>Dependency Injection — внедрение зависимостей (Koin)</li>
  <li><b>Unidirectional Data Flow</b> — однонаправленный поток данных в Compose</li>
  <li><b>State Hoisting</b> — подъём состояния для переиспользования компонентов</li>
</ul>

<h2>Полученные навыки</h2>
<ul>
  <li><b>Создание UI на Jetpack Compose</b> — декларативный подход к вёрстке</li>
  <li><b>Работа с @Composable-функциями</b></li>
  <li><b>Управление состоянием</b> — remember, mutableStateOf, StateFlow, collectAsState</li>
  <li><b>Использование модификаторов</b> — padding, clip, clickable, fillMaxSize и др.</li>
  <li><b>Создание переиспользуемых компонентов</b> — композиция вместо наследования</li>
  <li><b>Работа с LazyColumn</b> — эффективное отображение списков</li>
  <li><b>Настройка навигации</b> — Navigation Compose с типобезопасными маршрутами</li>
  <li><b>Загрузка изображений</b> — Glide Compose</li>
  <li><b>Темизация приложения</b> — Material 3 и кастомные темы</li>
  <li><b>Обработка side effects</b> — LaunchedEffect для Toast и навигации</li>
  <li><b>Применение Unidirectional Data Flow</b> — связь ViewModel и Compose</li>
</ul>

<h2>▶️ Сборка и запуск</h2>

<pre>
<code>
# Клонирование репозитория
git clone &lt;repository-url&gt;
cd Films

# Сборка
./gradlew assembleDebug

# Установка
./gradlew installDebug
</code>
</pre>

<h2>📌 Назначение проекта</h2>
<p>
Учебный проект для глубокого изучения <b>Jetpack Compose</b> и сравнения с классическим XML-подходом.<br>
Демонстрирует переход к декларативному UI, управление состояниями, навигацию и создание переиспользуемых компонентов.
</p>
