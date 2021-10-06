import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class MiniTextGame {

    public static void main(String[] args) {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);

        String race, role, name, answer, answer2, answer3, answer4;

        String gameOver = " . . .  \n" +

                "*Вы очнулись в просторной светлой комнате, Вы видите около десятка кроватей вокруг, на некоторых лежат полностью забинтованные персонажи, как, впрочем, и Вы.\n"
                + " Рядом с одной из кроватей стоит лекарь, делает какие-то записи в свой берестяной блокнот. \n"
                + "Вы пытаетесь пошевелиться и тут же все тело пронзает боль. Похоже, Ваше путешествие окончено.* \n"
                + "* * * GAME OVER * * *";

////////////////////////Intro
        System.out.println("... Где-то на окраинах далекой-далекой галактики ...");
        System.out.println("");
        System.out.println("- Добро пожаловать в фэнтезийнoe королевство Тельранион! \n"
                + "- Меня зовут Пепе, я твой гид. Назначен Великим Королем Тельраниона для помощи будущим героям. \n"
                + "- Можно долго рассказывать о прелестях, красотах и прочих ништяках этого прекрасногo мира, но! \n"
                + "- Как водится в этих жанрах, Великое Зло пытается уничтожить Тельранион. \n"
                + "- Оно пришло из далеких неведомых краев чтобы разрушить королевство набором ужасного оружия: выгорание, демотивация и самое жуткое - лень! \n"
                + "- И тебе, герой, предстоит с этим разобраться.\n"
                + "- Нет времени объяснять подробнее, просто помни, не только лишь все, но и не каждый сможет пройти этот путь до конца. Приступим!");
        System.out.println("");
        System.out.println(" . . . Создание персонажа . . .");

//////////////////////// STEP1. Creating character: race, role, name. Result

        try {
            //////////////////////// race
            System.out.println(" - - Выбери расу: тривиальный ЧЕЛОВЕК, утонченный ЭЛЬФ или дикий ОРК? - -");
            System.out.println(" -> ");

            race = createRace();

            //////////////////////// role
            System.out.println(" - - Выбирай, кем будет твой герой: мощный ВОИН, мудрый МАГ или хитрый РАЗБОЙНИК? - -");
            System.out.println("->");

            role = createRole();

            //////////////////////// name
            System.out.println(" - - Осталось придумать имя - -");
            System.out.println("->");

            name = createName(race, role);

            result(race, role);

            System.out.println("- Готово, отправляйся на битву со Злом!");

//            answer = br.readLine();
            while (true) {
                System.out.println(" - - Направиться к ВЫХОДу из селения? ...а что это за сундучок в углу? ОСМОТРЕТЬ? - -");
                System.out.println("->");
                answer = br.readLine();
                if (answer.equalsIgnoreCase("ОСМОТРЕТЬ")) {
                    System.out.println(
                            "*Пошарив по дну взглядом, Вы обнаружили потертую игральную кость. Сунув ее в карман, Вы продолжили путь.*");
                    System.out.println(" . . . Выход из селения . . . ");
                    break;
                } else {
                    System.out.println("*Вас охватывает чувство, что чего-то не хватает. Может Вы забыли что-то? Утюг? Чайник? Вы озираетесь по сторнам.*");
                }
            }

//////////////////////// STEP2. Wasteland, First battle
            System.out.println("");
            System.out.println(
                    "- Вот ты и выбрался за границы родной деревни. \n - \'Что делать?\' \'Куда идти?\' задаешься ты вопросом и у меня есть для тебя ответ! \n "
                            + "- Поднимать уровень! О да, герой, именно так! \n "
                            + "- Чтобы победить Великое Зло нужен высокий уровень иначе это уже что угодно, но не игра. \n "
                            + "- Смотри, вон там, на полянке с желтыми цветочками. Видишь? \n - Это же кабанчик! Лучший вариант для поднятия уровня. Верь мне!");
            System.out.println(" - - Для продолжения нажмите \'Enter\' - -");
            answer2 = br.readLine();
            System.out.println(" . . . ");
            System.out.println(" . . . Осторожно подбираемся к пасущемуся кабанчику . . .");
            System.out.println(" . . . ");

            System.out.println(
                    "*Приблизившись, вы замечаете, что кабанчик уже не так мил и безобиден как показалось на первый взгляд.\n"
                            + "*Крупнее самой крупной собаки, которой Вам доводилось встречать, под жесткой щетиной перекатываются крупные мышцы,\n огромную иссеченную шрамами морду украшают жуткого вида крупные клыки, \n а эти красные, свирепые глаза смотрят прямо на вас!* \n"
                            + "- ОН ТЕБЯ ЗАМЕТИЛ! ДЕЛАЙ ЧТО-НИБУДЬ!");
            System.out.println("");
            System.out.println(" - - Выбери действие: АТАКА, ОТСТУПИТЬ, бросить КУБИК - -");
            System.out.println("-> ");

            if (createBattle(race, role, name, answer, gameOver)) {
                System.out.println(" . . . ");
                System.out.println(" - - Для продолжения нажмите \'Enter\' - -");
                System.out.println(" . . . ");
                answer4 = br.readLine();

                System.out.println("*Вы чувствуете как кубик в Вашем кармане стал теплым. Вынув его и разглядывая на ладони, Вы обнаружили, что он еще и слегка светится приятным пурпурным светом.*");
                System.out.println("- Хм. Похоже, что эта игральная кость активировалась после того, как ты получил свой уровень. Вероятно он не так прост как выглядит.\n" +
                        "- Сейчас я телепортирую нас ко входу в пещеру Великого Зла, а с ним *кивает на кость* разберемся по пути." +
                        "*Вы слишите как Пепе начинает повторять нараспев \'javaMagicVoodooMagic\' и мир вокруг Вас начинает вращаться быстро набирая скокрость*");
                System.out.println(" . . . Перемещение в новую локацию . . .");

                while (true) {
                    System.out.println("*Мгновение спустя Вы оказываетесь перед входом в пещеру. Странный неразборчивый шепот из недр, непроглядная тьма и кости вокруг входа, намекают Вам, что это именно та пещера.* \n" +
                            "- Отступать поздно, герой. Теперь только вперед. Самое время опробовать твой кубик. Вдруг он как-то поможет?");
                    System.out.println(" - - Бросить КУБИК - -");
                    answer3 = br.readLine();
                    if (answer3.equalsIgnoreCase("кубик")) {
                        int res = diceRoll();
                        if (res >= 10 && res <= 20) {
                            System.out.println("*Внезапно перед Вами вспыхнул огонек, размером с яблоко, он парит и освещает все вокруг лучше любого факела.* \n" +
                                    "- Ого! Это магический свет! Он будет освещать нам путь во тьме пещеры.");
                            break;
                        }
                        if (res >= 1 && res < 10) {
                            System.out.println("*На земле перед Вами материализовался факел* \n" +
                                    "- Не дурно. Это поможет нам в непроглядной тьме пещеры.");
                            break;
                        }

                    } else {
                        System.out.println("- Можно подумать, тебе вообще не интересно узнать что с ним такое. Бросай давай!");
                    }
                }
                System.out.println(" . . . ");
                System.out.println(" - - Для продолжения нажмите \'Enter\' - -");
                System.out.println(" . . . ");
                answer4 = br.readLine();

////////////////////////STEP3. Dungeon, Great Evil, Final battle
                System.out.println("*Войдя в пещеру Вы озираетесь по сторонам. Света вполне достаточно, чтобы разглядеть надписи на неровных стенах. \n" +
                        "*Вы замечаете надпись \'hElow Word!\', явно написано дрожащей рукой. \n" +
                        "*Пройдя глубже по петляющему коридору пещеры, Вы видите развилку. \'Влево или вправо?\' думаете Вы. Но присмотревшись к стене левого коридора,\n *Вы видите недописанную надпись \'console.log...\' перечеркнутую глубокими бороздами крепких когтей.\n" +
                        "*Вам определенно не туда.*");

                System.out.println(" . . . ");
                System.out.println(" - - Для продолжения нажмите \'Enter\' - -");
                System.out.println(" . . . ");
                answer4 = br.readLine();
                System.out.println("Продвигаясь все дальше и дальше во мрак пещеры, тревога внутри наростала. Странный неразборчивый шепот, что был слышен при входе, перерос в почти разборчивое бормотание,\n а иногда доносились и вполне понятные обрывки фраз: \'вы должны! я же...\' или \'где мои печеньки? я же...\' \n" +
                        "- Все это души заблудших, не прошедших путь до конца.\n *ответил Пепе на Ваш безмолвный вопрос*\n *Но Вы же пройдете? Так ведь?* \n" +
                        "*Вместе с тем, не смотря на сомнения и страх, Вы продолжали двигаться. Шаг за шагом. Крики, всхлипы, мольбы о помощи... еще шажок.*\n" +
                        "*Потеряв счет времени Вы брели по жутким коридорам, бормоча и доказывая что-то тихому и приунывшему Пепе. Пока перед Вами не возникла мощная дверь, сложенная из темных крепких бревен и обитая железом.\n*" +
                        "- Мы на месте. За этой дверью и скрывается Великое Зло.");
                System.out.println(" . . . ");
                System.out.println(" - - Для продолжения нажмите \'Enter\' - -");
                System.out.println(" . . . ");
                answer4 = br.readLine();
                System.out.println("*Войдя в помещение, Вы видите огромный, ярко освещенный колонный зал. Тут и там стоят игровые автоматы. \n  " +
                        "*Огромные телевизоры с подключенными консолями. Автоматы для продажи сладостей, судя по вывескам на них, работают без монет.\n" +
                        "*Великое множество приглашений на всевозможные вечеринки, просто разбросаны по всем поверхностям зала.\n" +
                        "*За всей техникой, диванами и креслами, катающимися, летающими гаджетами, не было видно границ этой залы.*\n" +
                        "*А в цетре всего этого великолепия развлечений восседал гигантский дракон.\n" +
                        "*Тихо охнув, Пепе подпер спиной стену. Ваши ноги вдруг стали мягкими и непослушными, а руки отяжелели, словно стали из свинца. \n" +
                        "*Когда дракон заговорил, Вы с удивлением обнаружили, что голос его звучит у Вас в голове. И, отчего-то, он кажется жутко знакомым.*\n" +
                        "Дракон: Я знал, что ты прийдешь. Знаю цель твоего визита. Но зачем? Оглянись вокруг! У меня есть все, чего тебе хочется. Развлечения на любой вкус! Оставь свои попытки сразить меня. Присоединись ко мне и мы будем летать!");

                if (badEndGame()) {
                    System.out.println("Твой ход. АТАКА.");
                    int rand = diceRoll();
                    finalBattle(role, gameOver, name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //////////////////////// === race method ===
    public static String createRace() {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);
        String race = null;
        try {
            while (true) {
                race = br.readLine();
                if (race.equalsIgnoreCase("человек")) {
                    System.out.println("Человек так человек");
                    System.out.println(
                            "Описание: и без описаний знаем все минусы и плюсы человеческой расы. Продолжим...");
                    break;

                }
                if (race.equalsIgnoreCase("эльф")) {
                    System.out.println("Вот как? Выбор натуры с тонкой душевной организацией. ");
                    System.out.println("Описание: снобизм и эстетика. Магия у них в крови. Продолжим...");
                    break;

                }
                if (race.equalsIgnoreCase("орк")) {
                    System.out.println("\"LOK'TAR OGAR!\" или \" WAAAGH!\" теперь ваше жизненное кредо. ");
                    System.out.println(
                            "Описание: здоровенный, плохо пахнущий и вечно орущий. Мастер владения любым видом холодного оружия. Продолжим...");
                    break;

                } else {
                    System.out.println("- Не то. Выбери из предложенных выше.");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return race;
    }

    //////////////////////// === role method ===
    public static String createRole() {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);
        String role = null;
        try {
            while (true) {
                role = br.readLine();

                if (role.equalsIgnoreCase("воин")) {
                    System.out.println("Замечательно! Теперь ты ВОИН.");
                    System.out.println("Ты получаешь длинный меч, тяжелый щит и сияющие доспехи.");
                    break;
                }

                if (role.equalsIgnoreCase("маг")) {
                    System.out.println("Замечательно! Теперь ты МАГ.");
                    System.out.println(
                            "Ты получаешь искрящийся посох великой мощи стихий (береги бороду!) и расшитый халат.");
                    break;
                }

                if (role.equalsIgnoreCase("разбойник")) {
                    System.out.println("Замечательно! Теперь ты РАЗБОЙНИК.");
                    System.out.println(
                            "Ты не получаешь ничего, ведь разбойник сам берет то, что ему положено! Ну ладно, вот тебе пара красивых кинжалов со стразиками и черная повязка на глаза.");
                    break;
                } else {
                    System.out.println("- Опять? Прекращай. Выбери из предложенных выше.");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return role;
    }

    ////////////////////////=== name method ===
    public static String createName(String race, String role) {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);
        String name = null;
        try {
            while (true) {
                name = br.readLine();
                if (name.isEmpty()) {
                    System.out.println(
                            "- Ты можешь ввести что-угодно, но нельзя оставить героя совсем без имени. Что, в таком случае, барды и скальды будут воспевать в веках? Давай по-новой!");
                } else {

                    System.out.println("- Штош...");
                    System.out.println(race.toUpperCase() + " в роли " + role.toUpperCase() + "А" + " по имени "
                            + name.toUpperCase() + ". кхм... не плохо, да.");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    //////////////////////// === result method ===
    public static void result(String race, String role) {

        // about human
        if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("ВОИН"))) {
            System.out.println("- Да-да, красавчик. Оставь зеркало и соберись!");
        }

        if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("разбойник"))) {
            System.out.println("- Не, ну вы гляньте как у этого человека глазки загорелись!");
        }
        if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("МАГ"))) {
            System.out.println("- Нет, ты не сможешь превращать навоз в золото. Соберись!");
        }
        /// about elf
        if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("ВОИН"))) {
            System.out.println("- Серьезно? Остается надеяться, что он не раздавит себя тяжестью доспехов");
        }
        if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("МАГ"))) {
            System.out.println("- Что может быть прекрасней, чем гармоничное сочетание расы и роли?");
        }
        if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("разбойник"))) {
            System.out.println("- Это будет любопытно.");
        }
        // about orc
        if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("ВОИН"))) {
            System.out.println("- HELL YEAH! ХАЛК! КРУШИТЬ!");
        }
        if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("МАГ"))) {
            System.out.println("- Наверняка он расценивает посох как боевую дубину");
        }
        if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("разбойник"))) {
            System.out.println("*шепот* - Надеюсь, враги не учуют его аромат...");
        }

    }

    //////////////////////// === action for piggy method ===
    public static boolean createBattle(String race, String role, String name, String answer, String gameOver) {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);
        String action = null;
        try {

            // for humanWAR
            while (true) {
                action = br.readLine();
                if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("воин"))
                        && (action.equalsIgnoreCase("атака"))) {
                    System.out.println(
                            "*Недолго думая, прикрывшись щитом от атаки клыками, Вы выхватываете меч из ножен и, \n "
                                    + "сделав небольшой поворот корпуса, не без труда, вонзаете меч в тушу по самую рукоять.*");
                    System.out.println(" . . .");
                    System.out.println(
                            " - Поздравляю! Этого оказалось достаточно, чтобы добыть себе сытный ужин и поднять уровень! Что значит \'какой\'? Высокий! Ну, скажем, восьмидесятый. Вот... \n"
                                    + "Отныне герой " + name.toUpperCase() + " " + role.toUpperCase()
                                    + " 80-го уровня!");
                    return true;
                }
                if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("воин"))
                        && (action.equalsIgnoreCase("отступить"))) {
                    System.out.println(
                            "*Вы пытаетесь тактически маневрировать, но предательский корень позади, торчащий из земли и незамеченный ранее, делает подножку. Вы посрамлены и втоптаны в землю.*");
                    System.out.println(gameOver);
                    break;
                }
                if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("воин"))
                        && (action.equalsIgnoreCase("кубик")) && (answer.equalsIgnoreCase("ОСМОТРЕТЬ"))) {
                    System.out.println(
                            "- Знаешь, это крайне странное решение в сложившейся ситуации, но, безусловно, выбор твой. Только как это помо... \n"
                                    + "*После броска кубика, Вы успели заметить \'5\' на верхней грани двадцатигранного кубика и тень.\n"
                                    + " Тень стремительно приближающегося кабанчика. Удар. Blackout.*");
                    System.out.println(gameOver);
                    break;
                }


                // for humanMAGE
                if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("маг"))
                        && (action.equalsIgnoreCase("атака"))) {
                    System.out.println("- Давай! Испепели! Заморозь! РАЗУПЛОТНИ!");
                    System.out.println(
                            "*Вы воздели посох над головой и начали произносить на распев, повышая голос и укрепляя заклинание, слова \"наследованиеИнкАпсулЯцияПОЛИМОРФИЗМ!\n"
                                    + "*Раздался гром, искры из посоха превратились в ослепительный поток света, земля задрожала, а мгоновение спустя все стихло. \n"
                                    + " На месте кабанчика оказалась лишь полянка выжженой земли и горстка пепла.* \n ");
                    System.out.println(" . . .");
                    System.out.println(
                            " - Поздравляю! Этого оказалось достаточно, чтобы испепелить свой ужин и поднять уровень! Что значит \'какой\'? Высокий! Ну, скажем, восьмидесятый. Вот... \n"
                                    + "- Отныне герой " + name.toUpperCase() + " - " + role.toUpperCase()
                                    + " 80-го уровня!");
                    return true;
                }
                if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("маг"))
                        && (action.equalsIgnoreCase("отступить"))) {
                    System.out.println(
                            "*Вы пытаетесь тактически маневрировать, но предательский корень позади, торчащий из земли и незамеченный ранее, делает подножку. Вы посрамлены и втоптаны в землю.*");
                    System.out.println(gameOver);
                    break;
                }
                if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("маг"))
                        && (action.equalsIgnoreCase("кубик")) && (answer.equalsIgnoreCase("ОСМОТРЕТЬ"))) {
                    System.out.println(
                            "- Знаешь, это крайне странное решение в сложившейся ситуации, но, безусловно, выбор твой. Только как это помо... \n"
                                    + "*После броска кубика, Вы успели заметить \'2\' на верхней грани двадцатигранного кубика и тень.\n"
                                    + " Тень стремительно приближающегося кабанчика. Удар. Blackout.*");
                    System.out.println(gameOver);
                    break;
                }


                // for humanROGUE
                if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("разбойник"))
                        && (action.equalsIgnoreCase("атака"))) {
                    System.out.println("*Кувырок! Перекат! Влево! Вправо! \n"
                            + "Клинки сверкают как молнии! Да, стразики делают свое дело. \n " + "Перекат! Еще удар! \n"
                            + "Ваша атака была такой стремительной, что кабанчки даже не успел сдвинуться с места.*");
                    System.out.println(" . . .");
                    System.out.println(
                            " - Поздравляю! Этого оказалось достаточно, чтобы подготовить рубленный фарш к ужину и поднять уровень! Что значит \'какой\'? Высокий! Ну, скажем, восьмидесятый. Вот... \n"
                                    + "- Отныне герой " + name.toUpperCase() + " - " + role.toUpperCase()
                                    + " 80-го уровня!");
                    return true;

                }
                if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("разбойник"))
                        && (action.equalsIgnoreCase("отступить"))) {
                    System.out.println(
                            "*Плавно скользя словно тень, с кошачьей грацией Вы уклоняетесь от неистовой атаки черной, как уголь, кабанчиковой туши. \n"
                                    + "Кабанчик пронесся мимо и застыл в недоумении водя рылом в поисках жертвы. \n"
                                    + "Воспользовавшись секундой свиного замешательства Вы нанесли серию ударов.");
                    System.out.println(" . . .");
                    System.out.println(
                            " - Поздравляю! Этого оказалось достаточно, чтобы подготовить рубленый фарш к ужину и поднять уровень! Что значит \'какой\'? Высокий! Ну, скажем, восьмидесятый. Вот... \n"
                                    + "- Отныне герой " + name.toUpperCase() + " - " + role.toUpperCase()
                                    + " 80-го уровня!");
                    return true;
                }
                if ((race.equalsIgnoreCase("человек")) && (role.equalsIgnoreCase("разбойник"))
                        && (action.equalsIgnoreCase("кубик")) && (answer.equalsIgnoreCase("ОСМОТРЕТЬ"))) {
                    System.out.println(
                            "- Знаешь, это крайне странное решение в сложившейся ситуации, но, безусловно, выбор твой. Только как это помо... \n"
                                    + "*После броска кубика, Вы успели заметить \'5\' на верхней грани двадцатигранного кубика и тень.\n"
                                    + " Тень стремительно приближающегося кабанчика. Удар. Blackout.*");
                    System.out.println(gameOver);
                    break;
                }


                // for elfWAR
                if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("воин"))
                        && (action.equalsIgnoreCase("атака"))) {
                    System.out.println(
                            "*Испустив боевой визг, Вы попытались извлечь меч из ножен, но что-то пошло не так: \n "
                                    + "то ли меч застрял, то ли его вес был слишком большой для тонких эльфийский рук. \n"
                                    + " В любом случае, Вы так и не поняли, что же так громко звякнуло.*");
                    System.out.println(gameOver);
                    break;
                }
                if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("воин"))
                        && (action.equalsIgnoreCase("отступить"))) {
                    System.out.println(
                            "*Вы пытаетесь броситься наутек, в сторону или куда-нибудь, но тяжесть доспехов, щита и меча, заставили Вас врасти в землю. \n"
                                    + " Удар! Звон металла! Довольный хрюк! Занавес.");
                    System.out.println(gameOver);
                    break;
                }
                if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("воин"))
                        && (action.equalsIgnoreCase("кубик")) && (answer.equalsIgnoreCase("ОСМОТРЕТЬ"))) {
                    System.out.println(
                            "- Знаешь, это крайне странное решение в сложившейся ситуации, но, безусловно, выбор твой. Только как это помо... \n"
                                    + "*После броска кубика, Вы успели заметить \'2\' на верхней грани двадцатигранного кубика и тень.\n"
                                    + " Тень стремительно приближающегося кабанчика. Удар. Blackout.*");
                    System.out.println(gameOver);
                    break;
                }


                // for elfMAGE
                if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("маг"))
                        && (action.equalsIgnoreCase("атака"))) {
                    System.out.println(
                            "*Выкрик \'encapsulation!\': посох вырвался из ваших рук и повис в воздухе перед Вами. \n"
                                    + "Вы раскинули руки в стороны. Выкрик \'inheritance!\': на кончиках пальцев заплясали разноцветные искры. \n"
                                    + "Выкрик \'polymorphism!\': свет вокруг пальцев начал тянуться к верхушке парящего посоха и формироваться в сферу, на поверхности которой рябью пробегали единички и нолики. \n"
                                    + "Крик, заглушающий гул потоков магии и ветра \'ABSTARCTIOOOON!\': хлопок руками перед собой, сфера сорвалась с верхушки посоха и устремилась молнией в бегущего кабанчика. \n"
                                    + "ВСПЫШКА! ... Тишина. Когда свет стал естественным и пыль улягась, Вы обнаружили вместо кабанчика связку чудесных свиных сосисок. ");

                    System.out.println(" . . .");
                    System.out.println(
                            "- Это было великолепно! Я даже не представляю что это было за кунг-фу такое, но этого, конечно же, достаточно чтобы поднять уровень и даже больше! Вот... \n"
                                    + "- Отныне герой " + name.toUpperCase() + " - " + race.toUpperCase()
                                    + " 80-го уровня! \n" + "- А также, герой " + name.toUpperCase() + " теперь "
                                    + role.toUpperCase() + " 100-го уровня!");
                    return true;
                }
                if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("маг"))
                        && (action.equalsIgnoreCase("отступить"))) {
                    System.out.println(
                            "*Направив верхушку посоха в сторону бегущего на Вас кабанчика, Вы крикнули \'piggyIsEmpty()!\' \n "
                                    + "и свирепое животное, в мгновении ока, начало истончаться и испаряться, оставляя шлейф из еле заметных единичек и ноликов");
                    System.out.println(" . . .");
                    System.out.println(
                            " - Поздравляю! Этого оказалось достаточно, чтобы разуплотнить Ваш ужин и поднять уровень! Что значит \'какой\'? Высокий! Ну, скажем, восьмидесятый. Вот... \n"
                                    + "- Отныне герой " + name.toUpperCase() + " - " + role.toUpperCase()
                                    + " 80-го уровня!");
                    return true;
                }
                if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("маг"))
                        && (action.equalsIgnoreCase("кубик")) && (answer.equalsIgnoreCase("ОСМОТРЕТЬ"))) {
                    System.out.println(
                            "- Знаешь, это крайне странное решение в сложившейся ситуации, но, безусловно, выбор твой. Только как это помо... \n"
                                    + "*После броска кубика, Вы успели заметить \'2\' на верхней грани двадцатигранного кубика и тень.\n"
                                    + " Тень стремительно приближающегося кабанчика. Удар. Blackout.*");
                    System.out.println(gameOver);
                    break;
                }
                if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("маг"))
                        && (action.equalsIgnoreCase("кубик"))) {
                    System.out.println("Что? Какой кубик? КАБАНЧИК АТАКУЕТ! \n"
                            + "*Вы так и не успели понять суть своих действий. Атака кабанчика была яростной и стремительной.*");
                    System.out.println(gameOver);
                    break;
                }

                // for elfROGUE
                if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("разбойник"))
                        && (action.equalsIgnoreCase("атака"))) {
                    System.out.println(
                            "*Вы прекрасно двигаетесь. Грация и легкость, точность и скорость. Но вот чего действительно не хватает, так это силы, чтобы пробить кинжалами толстую кабанчиковую кожу.");
                    System.out.println(gameOver);
                    break;
                }
                if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("разбойник"))
                        && (action.equalsIgnoreCase("отступить"))) {
                    System.out.println(
                            "*Прекрасный пируэт! Еще па и враг снова пронесся мимо. Вы готовы кружиться в этом танце вечность, но внезапно закончилась выносливость.");
                    System.out.println(gameOver);
                    break;
                }
                if ((race.equalsIgnoreCase("эльф")) && (role.equalsIgnoreCase("разбойник"))
                        && (action.equalsIgnoreCase("кубик")) && (answer.equalsIgnoreCase("ОСМОТРЕТЬ"))) {
                    System.out.println(
                            "- Знаешь, это крайне странное решение в сложившейся ситуации, но, безусловно, выбор твой. Только как это помо... \n"
                                    + "*После броска кубика, Вы успели заметить \'5\' на верхней грани двадцатигранного кубика и тень.\n"
                                    + " Тень стремительно приближающегося кабанчика. Удар. Blackout.*");
                    System.out.println(gameOver);
                    break;
                }


                // for orcWar
                if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("воин"))
                        && (action.equalsIgnoreCase("атака"))) {
                    System.out.println(
                            "*Отбросив щит, перехватив меч поудобнее, одним точным, уверенным движением Вы разрубили свирепое животное на три... о, погодите-ка, на четыре части!");
                    System.out.println(" . . .");
                    System.out.println(
                            " - Поздравляю! Этого оказалось достаточно, чтобы приготовить сочных стейков к ужину и поднять уровень! Что значит \'какой\'? Высокий! Ну, скажем, восьмидесятый. Вот... \n"
                                    + "- Отныне герой " + name.toUpperCase() + " - " + role.toUpperCase()
                                    + " 80-го уровня!");
                    return true;
                }
                if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("воин"))
                        && (action.equalsIgnoreCase("отступить"))) {
                    System.out.println(
                            "*Отступить? Что за вздор? Издав боевой клич древних предков \'FUS-RO-DAH!\', Вы бросились на атакующего Вас кабанчика. Даже голыми руками вы с легкостью одолели врага.*");
                    System.out.println(" . . .");
                    System.out.println(
                            " - Поздравляю! Этого оказалось достаточно, чтобы приготовить сочные отбивные к ужину и поднять уровень! Что значит \'какой\'? Высокий! Ну, скажем, восьмидесятый. Вот... \n"
                                    + "- Отныне герой " + name.toUpperCase() + " - " + role.toUpperCase()
                                    + " 80-го уровня!");
                    return true;
                }
                if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("воин"))
                        && (action.equalsIgnoreCase("кубик")) && (answer.equalsIgnoreCase("ОСМОТРЕТЬ"))) {
                    System.out.println(
                            "- Знаешь, это крайне странное решение в сложившейся ситуации, но, безусловно, выбор твой. Только как это помо... \n"
                                    + "*После броска кубика, Вы успели заметить \'2\' на верхней грани двадцатигранного кубика и тень.\n"
                                    + " Тень стремительно приближающегося кабанчика. Удар. Blackout.*");
                    System.out.println(gameOver);
                    break;
                }


                // for orcMAGE
                if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("маг"))
                        && (action.equalsIgnoreCase("атака"))) {
                    System.out.println(
                            "*Размахивая магическим посохом как палкой и выкрикивая, определенно, не заклинания, Вы ринулись в атаку. \n"
                                    + " Как результат, посох-палка разлетелся в щепки при первом же ударе. Высвобожденная энергия стихий сдетонировала и очистила обширную территорию от любой флоры и фауны.");
                    System.out.println(gameOver);
                    break;
                }
                if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("маг"))
                        && (action.equalsIgnoreCase("отступить"))) {
                    System.out.println(
                            "Успешно маневрируя Вы отступаете. Все идет как надо, вот-вот Вы выйдете из боя целым и невредимым.\n"
                                    + " Но вдруг, кабанчик резко меняет тактику и заходит с фланга! Вы профессионально блокируете удар посохом. \n."
                                    + " Слышится треск ломаемой древесины. Это посох, не выдержав натиска, разлетелся в щепки. \n "
                                    + "Высвобожденная энергия стихий сдетонировала и очистила обширную территорию от любой флоры и фауны");

                    System.out.println(gameOver);
                    break;
                }
                if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("маг"))
                        && (action.equalsIgnoreCase("кубик")) && (answer.equalsIgnoreCase("ОСМОТРЕТЬ"))) {
                    System.out.println(
                            "- Знаешь, это крайне странное решение в сложившейся ситуации, но, безусловно, выбор твой. Только как это помо... \n"
                                    + "*После броска кубика, Вы успели заметить \'2\' на верхней грани двадцатигранного кубика и тень.\n"
                                    + " Тень стремительно приближающегося кабанчика. Удар. Blackout.*");
                    System.out.println(" . . .");
                    System.out.println(gameOver);
                    break;
                }


                // for orcROGUE
                if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("разбойник"))
                        && (action.equalsIgnoreCase("атака"))) {
                    System.out.println(
                            "*С криками о родословной кабанчика, Вы бросаетесь в атаку. Хватило одного удара, чтобы кабанчик сдался");
                    System.out.println(" . . .");
                    System.out.println(
                            " - Поздравляю! Этого оказалось достаточно, чтобы нарубить сочных стейков к ужину и поднять уровень! Что значит \'какой\'? Высокий! Ну, скажем, восьмидесятый. Вот... \n"
                                    + "- Отныне герой " + name.toUpperCase() + " - " + role.toUpperCase()
                                    + " 80-го уровня!");
                    return true;
                }
                if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("разбойник"))
                        && (action.equalsIgnoreCase("отступить"))) {
                    System.out.println(
                            "*Вы попытались профессионально отпрыгнуть в сторону, но, с грацией мешка картошки, просто повалилсь на землю.");
                    System.out.println(gameOver);
                    break;
                }
                if ((race.equalsIgnoreCase("орк")) && (role.equalsIgnoreCase("разбойник"))
                        && (action.equalsIgnoreCase("кубик")) && (answer.equalsIgnoreCase("ОСМОТРЕТЬ"))) {
                    System.out.println(
                            "- Знаешь, это крайне странное решение в сложившейся ситуации, но, безусловно, выбор твой. Только как это помо... \n"
                                    + "*После броска кубика, Вы успели заметить \'5\' на верхней грани двадцатигранного кубика и тень.\n"
                                    + " Тень стремительно приближающегося кабанчика. Удар. Blackout.*");
                    System.out.println(gameOver);
                    break;
                } else {
                    System.out.println(
                            "- Тестировщик, штоле? Тебя вот-вот выпотрошит кабанчик, а ты ищешь баги? В другой раз.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //////////////////////// === random & final battle method ===
    public static int diceRoll() {
        int max = 20;
        int min = 1;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        return rand;
    }

    //////////////////////// === dragon's turn method ===
    public static int dragonAttack(String role) {
        int dAttack = 0;

        if (role.equalsIgnoreCase("воин")) {

            dAttack = diceRoll();

            System.out.println("Дракон наносит " + dAttack + " урона");

        }
        if (role.equalsIgnoreCase("маг")) {

            dAttack = diceRoll() + 10;
            System.out.println("Дракон наносит " + dAttack + " урона");

        }
        if (role.equalsIgnoreCase("разбойник")) {

            dAttack = diceRoll() + 5;
            System.out.println("Дракон наносит " + dAttack + " урона");

        }
        return dAttack;
    }

    //////////////////////// === hero attack method ===
    public static int heroAttack(String role) {
        int hAttack = 0;

        if (role.equalsIgnoreCase("воин")) {

            hAttack = diceRoll() + 20;
            if ((diceRoll() >= 15) && (diceRoll() <= 20)) {
                hAttack = hAttack * 2;
                System.out.println("Вы наносите критический удар и " + hAttack + " урона");
            }
            System.out.println("Вы наносите " + hAttack + " урона");

        }
        if (role.equalsIgnoreCase("маг")) {

            hAttack = diceRoll() + 30;
            if ((diceRoll() >= 15) && (diceRoll() <= 20)) {
                hAttack = hAttack * 2;
                System.out.println("Вы наносите критический удар и " + hAttack + " урона");
            }
            System.out.println("Вы наносите " + hAttack + " урона");
        }
        if (role.equalsIgnoreCase("разбойник")) {

            hAttack = diceRoll() + 20;
            if ((diceRoll() >= 15) && (diceRoll() <= 20)) {
                hAttack = hAttack * 2;
                System.out.println("Вы наносите критический удар и " + hAttack + " урона");
            }
            System.out.println("Вы наносите " + hAttack + " урона");
        }
        return hAttack;
    }

    //////////////////////// === end method ===
    public static boolean badEndGame() {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);
        String choice = null;
        try {

            while (true) {
                System.out.println(" - - Хотите ОСТАТЬСЯ в мире дракона или ВЫПОЛНИТЬ задачу и избавить королевство Тельранион от демотивации и лени? - -");
                System.out.println("-> ");
                choice = br.readLine();
                if (choice.equalsIgnoreCase("выполнить")) {
                    System.out.println("- ЗА КОРОЛЯ! ЗА ТЕЛЬРАНИОН!");
                    return true;
                }

                if (choice.equalsIgnoreCase("остаться")) {
                    System.out.println("*Вы сделали свой выбор. Никто и никогда не вспомнит о Вашем существовании.\n" +
                            "            _ПОТРАЧЕНО_ \n" +
                            "GAME OVER");
                    break;
                } else {
                    System.out.println("Если, из-за твоих тестов, нас сожрет дракон - Король нас казнит! А я скажу, что это все твоя вина!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //////////////////////// === final battle method ===
    public static String finalBattle(String role, String gameOver, String name) {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);
        String rollResult = null;
        ;
        try {
            int dragonHP = 300;
            int heroHP = 100;
            int count = 1;
            System.out.println("Количество очков здоровья Зла: " + dragonHP);
            System.out.println("Количество очков здоровья героя: " + heroHP);
            System.out.println("*Игральная кость усиливает ваши атаки*");
            while (true) {
                rollResult = br.readLine();
                System.out.println("step " + count);
                if (rollResult.equalsIgnoreCase("атака")) {
                    int hAttack = heroAttack(role);
                    dragonHP -= hAttack;
                    System.out.println("Очки здоровья дракона = " + dragonHP);

                    int dAttack = dragonAttack(role);
                    heroHP -= dAttack;
                    System.out.println("Очки здоровья героя = " + heroHP);
                    count++;
                    if (heroHP <= 0) {
                        System.out.println("*Вы чувствуете как силы покидают вас. Неужели это конец?" +
                                gameOver);
                        break;
                    }
                    if (dragonHP <= 0) {
                        System.out.println("*Вы повергли Великое Зло!\n*" +
                                "- ДА! У тебя получилось! Наконец-то Великое Королевство Тельранион свободно! Нас ждет пир! \n" +
                                "... и много работы по восстановлению... Но это будет позже, а сейчас заслуженный пир! \n" +
                                "*Невероятно эпически-геройская музыка. Герой уходит в закат. Благодарности за уделенное время. Слезы умиления.* \n" +
                                "Вместо титров: \n" +
                                "--------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                                "---------------------Великий герой Тельраниона " + name.toUpperCase() + " одолел Великое Зло за " + count + " ударов. Вечная ему хвала и слава!------------------------------------\n" +
                                "--------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                                "--------------------------------------------------------------------------TelRan_2021-------------------------------------------------------------\n" +
                                "--------------------------------------------------------------------------------------------------------------------------------------------------\n");
                        break;
                    }
                } else {
                    System.out.println("- Очень смешно. В разгар финальной битвы. Сфокусируйся!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rollResult;
    }
}
