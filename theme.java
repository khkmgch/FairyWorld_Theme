import java.util.Arrays;
import java.util.Random;

class RandomWrapper{
    public static int getRan(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }
    public static boolean ranBoolean(){
        return new Random().nextBoolean();
    }
}

class Poster{
    protected String current;

    public void setPoster(String poster){
        this.current = poster;
    }
    public String getRandomPoster(String[] posters){
        int randomInt = RandomWrapper.getRan(0, posters.length-1);
        return posters[randomInt];
    }
    public String toString(){
        String newline = System.lineSeparator();
        return newline + "- - - - - - - - - - - - - - - - - - - - " + newline + 
                (this.current != null ? this.current : "Coming soon!") + 
                newline + "- - - - - - - - - - - - - - - - - - - - " + newline;
    }
}

class SpringPoster extends Poster{
    private static final String[] STRINGARR = {"Cherry blossom festival is held!", "Let's take a walk in the cosmos field!"};

    public SpringPoster(){
        super();
        super.setPoster(super.getRandomPoster(this.STRINGARR));
    }
    public String[] getPosters(){
        return this.STRINGARR;
    }
}
class SummerPoster extends Poster{
    private static final String[] SUMMERARR = {"Fireworks display is held!", "Summer festival is held!", "Tanabata Festival is held!", "Yukata contest is held!"};

    public SummerPoster(){
        super();
        super.setPoster(super.getRandomPoster(this.SUMMERARR));
    }
    public String[] getPosters(){
        return this.SUMMERARR;
    }
}
class AutumnPoster extends Poster{
    private static final String[] AUTUMNARR = {"Momiji Festival is held!", "Autumn Harvest Festival is held!"};

    public AutumnPoster(){
        super();
        super.setPoster(super.getRandomPoster(this.AUTUMNARR));
    }
    public String[] getPosters(){
        return this.AUTUMNARR;
    }
}
class WinterPoster extends Poster{
    private static final String[] WINTERARR = {"Snow Festival is held!", "Christmas Market is held!"};

    public WinterPoster(){
        super();
        super.setPoster(super.getRandomPoster(this.WINTERARR));
    }
    public String[] getPosters(){
        return this.WINTERARR;
    }
}
class HalloweenPoster extends Poster{
    private static final String[] HALLOWEENARR = {"Halloween costume event is held!", "Trick or Treat!"};

    public HalloweenPoster(){
        super();
        super.setPoster(super.getRandomPoster(this.HALLOWEENARR));
    }
    public String[] getPosters(){
        return this.HALLOWEENARR;
    }
}
class ValentinePoster extends Poster{
    private static final String[] VALENTINEARR = {"Valentine's Party!!", "HAPPY Valentine!", "Valentine's Special Event!"};

    public ValentinePoster(){
        super();
        super.setPoster(super.getRandomPoster(this.VALENTINEARR));
    }
    public String[] getPosters(){
        return this.VALENTINEARR;
    }
}

class RGB24{
    private int red;
    private int green;
    private int blue;

    public RGB24(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    public RGB24(String inputStr){
        int l = inputStr.length();

        if(l == 6)this.setColorsByHex(inputStr);
        else if(l == 24)this.setColorsByBin(inputStr);
        else this.setAsBlack();
    }

    public void setColorsByHex(String hex){
        if(hex.length() != 6)this.setAsBlack();
        else{
            this.red = Integer.parseInt(hex.substring(0, 2), 16);
            this.green = Integer.parseInt(hex.substring(2, 4), 16);
            this.red = Integer.parseInt(hex.substring(4), 16);
        }
    }
    public void setColorsByBin(String bin){
        if(bin.length() != 24)this.setAsBlack();
        else{
            this.red = Integer.parseInt(bin.substring(0, 8), 2);
            this.green = Integer.parseInt(bin.substring(8, 16), 2);
            this.blue = Integer.parseInt(bin.substring(16), 2);
        }
    }
    public void setAsBlack(){
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }
    public String getHex(){
        return Integer.toHexString(this.red) + Integer.toHexString(this.green) + Integer.toHexString(this.blue);
    }
    public String getBin(){
        return Integer.toBinaryString(Integer.parseInt(this.getHex(), 16));
    }
    public String getColorShade(){
        if(this.red == this.green && this.green == this.blue) return "grayscale";
        String[] stringTable = new String[]{"red","green","blue"};
        int[] values = {this.red, this.green, this.blue};

        int max = values[0];
        int maxIndex = 0;
        for(int i = 1; i < values.length; i++){
            if(max <= values[i]){
                max = values[i];
                maxIndex = i;
            }
        }

        return stringTable[maxIndex];
    }
    public String toString(){
        return "rgb(" + this.red + "," + this.green + "," + this.blue + ") Hex: " + this.getHex() + ", binary: " + this.getBin();
    }
}

class StringOfLights{
    protected RGB24[] current;

    public void setLights(RGB24[] lights){
        this.current = lights;
    }
    public String toString(){
        return "Light patterns tonight is " + Arrays.toString(this.current);
    }
}

class SpringStringOfLights extends StringOfLights{
    // [ピンク、紫、オレンジ、青]
    private static final RGB24[] SPRINGARR = {new RGB24(234, 145, 152), new RGB24(167, 87, 168), new RGB24(255, 165, 0), new RGB24(0, 106, 182)};

    public SpringStringOfLights(){
        super();
        super.setLights(this.SPRINGARR);
    }
    public RGB24[] getRGB24Lights(){
        return this.SPRINGARR;
    }
}
class SummerStringOfLights extends StringOfLights{
    // [緑、黄、オレンジ]
    private static final RGB24[] SUMMERARR = {new RGB24(59, 175, 117), new RGB24(227, 199, 0), new RGB24(255, 165, 0)};

    public SummerStringOfLights(){
        super();
        super.setLights(this.SUMMERARR);
    }
    public RGB24[] getRGB24Lights(){
        return this.SUMMERARR;
    }
}
class AutumnStringOfLights extends StringOfLights{
    // [オレンジ、青]
    private static final RGB24[] AUTUMNARR = {new RGB24(255, 165, 0), new RGB24(0, 106, 182)};

    public AutumnStringOfLights(){
        super();
        super.setLights(this.AUTUMNARR);
    }
    public RGB24[] getRGB24Lights(){
        return this.AUTUMNARR;
    }
}
class WinterStringOfLights extends StringOfLights{
    // [緑、赤]
    private static final RGB24[] WINTERARR = {new RGB24(59, 175, 117), new RGB24(215, 29, 59)};

    public WinterStringOfLights(){
        super();
        super.setLights(this.WINTERARR);
    }
    public RGB24[] getRGB24Lights(){
        return this.WINTERARR;
    }
}
class HalloweenStringOfLights extends StringOfLights{
    // [オレンジ、緑、紫]
    private static final RGB24[] HALLOWEENARR = {new RGB24(255, 165, 0), new RGB24(59, 175, 117), new RGB24(167, 87, 168)};

    public HalloweenStringOfLights(){
        super();
        super.setLights(this.HALLOWEENARR);
    }
    public RGB24[] getRGB24Lights(){
        return this.HALLOWEENARR;
    }
}
class ValentineStringOfLights extends StringOfLights{
    // [ピンク、青、オレンジ]
    private static final RGB24[] VALENTINEARR = {new RGB24(234, 145, 152), new RGB24(0, 106, 182), new RGB24(255, 165, 0)};

    public ValentineStringOfLights(){
        super();
        super.setLights(this.VALENTINEARR);
    }
    public RGB24[] getRGB24Lights(){
        return this.VALENTINEARR;
    }
}

class LightShow{
    protected String show;

    public void setShow(String show){
        this.show = show;
    }
    public String getShow(){
        if(this.show == null)return "";
        return this.show;
    }
    public String toString(){
        if(this.show == null)return "";
        return "This is " + this.show;
    }
    public String narration(){
        String newline = System.lineSeparator();
        return "Welcome to Fairy World!" + newline + 
                "We will start a 20-minute night show from now. " + newline + 
                "Enjoy " + this.show + " that can only be seen this season!" + newline;
    }
}
class SpringLightShow extends LightShow{
    private static final String SPRINGSHOW = "a spring show with beautiful illuminated cherry blossoms and fountain";

    public SpringLightShow(){
        super();
        super.setShow(this.SPRINGSHOW);
    }
}
class SummerLightShow extends LightShow{
    private static final String SUMMERSHOW = "a summer show with grand fireworks";

    public SummerLightShow(){
        super();
        super.setShow(this.SUMMERSHOW);
    }
}
class AutumnLightShow extends LightShow{
    private static final String AUTUMNSHOW = "a autumn show filled with beautiful illuminated maple trees and fountain";

    public AutumnLightShow(){
        super();
        super.setShow(this.AUTUMNSHOW);
    }
}
class WinterLightShow extends LightShow{
    private static final String WINTERSHOW = "a winter show of reindeer and Santa Claus dancing in the snow";

    public WinterLightShow(){
        super();
        super.setShow(this.WINTERSHOW);
    }
}
class HalloweenLightShow extends LightShow{
    private static final String HALLOWEENSHOW = "a spooky halloween show";

    public HalloweenLightShow(){
        super();
        super.setShow(this.HALLOWEENSHOW);
    }
}
class ValentineLightShow extends LightShow{
    private static final String VALENTINESHOW = "a valentine's show filled with heart-shaped illuminations";

    public ValentineLightShow(){
        super();
        super.setShow(this.VALENTINESHOW);
    }
}

class Song{
    private String title;
    private String lyric;
    private int recordingTimeSec;

    public Song(String title, String lyric, int recordingTimeSec){
        this.title = title;
        this.lyric = lyric;
        this.recordingTimeSec = recordingTimeSec;
    }
    public String getTitle(){
        return this.title;
    }
    public String getLyric(){
        return this.lyric;
    }
    public int getRecordingTimeSec(){
        return this.recordingTimeSec;
    }
    public String toString(){
        String newline = System.lineSeparator();
        return "This is " + this.title + "." + newline + 
                "Recording time is " + Time.secToMinitesString(this.recordingTimeSec) + newline + 
                "Lyric: " + newline + this.lyric + newline;
    }
}

class MusicSong{
    protected Song current;

    public void setSong(Song song){
        this.current = song;
    }
    public Song getSong(){
        if(this.current == null)return null;
        return this.current;
    }
    public Song getRandomSong(Song[] songs){
        int randomInt = RandomWrapper.getRan(0, songs.length-1);
        return songs[randomInt];
    }
    public String toString(){
        if(this.current == null)return "";
        return this.current.toString();
    }
}

class SpringMusicSong extends MusicSong{
    private static final Song[] SPRING_SONGS = {
        new Song("ハルジオン", "あなたの言葉に頷き信じた私を　一人置き去りに時間は過ぎる　見えていたはずの　未来も指の隙間をすり抜けた　戻れない日々の欠片と　あなたの気配を　今でも探してしまうよ　まだあの日の二人に手を伸ばしてる", 198),
        new Song("TSUNAMI", "見つめ合うと素直にお喋り出来ない　津波のような侘しさに　I know ..怯えてる.Hoo...　めぐり逢えた瞬間から魔法が解けない　鏡のような夢の中で　思い出はいつの日も雨", 312),
        new Song("fragile", "「愛しい」だなんて 言い慣れてないケド 今なら言えるよ 君のために となりで笑って いてくれるのならば これ以上他に何も要らないよ", 290)
    };

    public SpringMusicSong(){
        super();
        super.setSong(super.getRandomSong(this.SPRING_SONGS));
    }

    public Song[] getSongs(){
        return this.SPRING_SONGS;
    }
}
class SummerMusicSong extends MusicSong{
    private static final Song[] SUMMER_SONGS = {
        new Song("花火", "夏の星座にぶらさがって上から花火を見下ろして　こんなに好きなんです 仕方ないんです　夏の星座にぶらさがって上から花火を見下ろして　涙を落として火を消した", 280),
        new Song("アゲハ蝶", "あなたに逢えた それだけでよかった　世界に光が満ちた　夢で逢えるだけでよかったのに　愛されたいと願ってしまった　世界が表情を変えた　世の果てでは空と海が交じる", 282),
        new Song("プラネタリウム", "行きたいよ 君のところへ 今すぐ かけだして 行きたいよ　まっ暗で何も 見えない 怖くても大丈夫　数えきれない星空が 今もずっと ここにあるんだよ　泣かないよ 昔 君と見た きれいな空だったから", 307)
    };

    public SummerMusicSong(){
        super();
        super.setSong(super.getRandomSong(this.SUMMER_SONGS));
    }

    public Song[] getSongs(){
        return this.SUMMER_SONGS;
    }
}
class AutumnMusicSong extends MusicSong{
    private static final Song[] AUTUMN_SONGS = {
        new Song("今宵の月のように", "今日もまたどこへ行く 愛を探しに行こう いつの日か輝くだろう あふれる熱い涙 Ah… Ah… Oh yeah…", 252),
        new Song("サウダージ", "許してね恋心よ 甘い夢は波にさらわれたの　いつかまた逢いましょう その日までサヨナラ恋心よ", 262)
    };

    public AutumnMusicSong(){
        super();
        super.setSong(super.getRandomSong(this.AUTUMN_SONGS));
    }

    public Song[] getSongs(){
        return this.AUTUMN_SONGS;
    }
}
class WinterMusicSong extends MusicSong{
    private static final Song[] WINTER_SONGS = {
        new Song("ヒロイン", "雪が綺麗と笑うのは君がいい　でも寒いねって嬉しそうなのも　転びそうになって掴んだ手のその先で　ありがとうって楽しそうなのも　それも君がいい", 269),
        new Song("白い恋人達", "今宵 涙こらえて奏でる愛のSerenade 今も忘れない恋の歌 雪よもう一度だけこのときめきをCelebrate ひとり泣き濡れた夜にWhite Love", 279)
    };

    public WinterMusicSong(){
        super();
        super.setSong(super.getRandomSong(this.WINTER_SONGS));
    }

    public Song[] getSongs(){
        return this.WINTER_SONGS;
    }
}
class HalloweenMusicSong extends MusicSong{
    private static final Song[] HALLOWEEN_SONGS = {
        new Song("ファッションモンスター", "ファッションモンスター　ファッションモンスター　このせまいこころの檻もこわして自由になりたいの　ファッションモンスター　ファッションモンスター", 277),
        new Song("Crazy Party Night～ぱんぷきんの逆襲～", "Pa Pa Party in The Pumpkin ダンシング ダンシング Halloween かわいいおばけと Hallo Halloween Pa Party in The Pumpkin  Crazy Crazy Crazy Night ダンシング ダンシング ぱんぷきんCrazy Party Night", 254)
    };

    public HalloweenMusicSong(){
        super();
        super.setSong(super.getRandomSong(this.HALLOWEEN_SONGS));
    }

    public Song[] getSongs(){
        return this.HALLOWEEN_SONGS;
    }
}
class ValentineMusicSong extends MusicSong{
    private static final Song[] VALENTINE_SONGS = {
        new Song("チョコレイト・ディスコ", "チョコレイト・ディスコ　チョコレイト・ディスコ　チョコレイト・ディスコ　チョコレイト・ディスコ　チョコレイト・ディスコ　チョコレイト・ディスコ　チョコレイト・ディスコ　チョコレイト・ディスコ　チョコレイト・ディスコ　チョコレイト・ディスコ　チョコレイト・ディスコ　ディスコ", 226),
        new Song("恋", "胸の中にあるもの いつか見えなくなるもの それは側にいること いつも思い出して 君の中にあるもの 距離の中にある鼓動 恋をしたの貴方の 指の混ざり 頬の香り 夫婦を超えてゆけ", 254)
    };

    public ValentineMusicSong(){
        super();
        super.setSong(super.getRandomSong(this.VALENTINE_SONGS));
    }

    public Song[] getSongs(){
        return this.VALENTINE_SONGS;
    }
}

class Time{
    public static String secToMinitesString(int inputSeconds){
        int minutes = inputSeconds / 60;
        int seconds = inputSeconds % 60;
        return minutes + " : " + seconds;
    }
}

class Person{
    private String firstName;
    private String lastName;
    private int age;
    private double heightM;
    private double weightKg;
    private String biologicalSex;

    public Person(String firstName, String lastName, int age, double heightM, double weightKg, String biologicalSex){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightM = heightM;
        this.weightKg = weightKg;
        this.biologicalSex = biologicalSex;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }
    public int getAge(){
        return this.age;
    }
    public String toString(){
        return this.getName();
    }
}

class Mascot{
    protected String name;
    protected double heightM;
    protected double widthM;
    protected String appearance;
    protected Person personInside;

    public Mascot(String name, double height, double width, String appearance, Person personInside){
        this.name = name;
        this.heightM = heightM;
        this.widthM = widthM;
        this.appearance = appearance;
        this.personInside = personInside;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        String newline = System.lineSeparator();
        return this.name + " mascot " + newline + this.getStatus();
    }
    public String getStatus(){
        String newline = System.lineSeparator();
        return "Height: " + this.heightM + newline + 
                "Width: " + this.widthM + newline + 
                "The appearance is " + this.appearance + newline + 
                this.personInside + " is inside this mascot. ";
    }
}

class MickeyMouse extends Mascot{
    private static final String NAME = "Mickey Mouse";
    private static final double HEIGHT = 1.6;
    private static final double WIDTH = 0.9;
    private static final String APPEARANCE = "mouse with big round ears";
    
    public MickeyMouse(Person person){
        super(MickeyMouse.NAME, MickeyMouse.HEIGHT, MickeyMouse.WIDTH, MickeyMouse.APPEARANCE, person);
    }
}

class SpringMickeyMouse extends MickeyMouse{
    public SpringMickeyMouse(Person person){
        super(person);
    }
    public String toString(){
        return "This is spring version: " + super.toString();
    }
}
class SummerMickeyMouse extends MickeyMouse{
    public SummerMickeyMouse(Person person){
        super(person);
    }
    public String toString(){
        return "This is summer version: " + super.toString();
    }
}
class AutumnMickeyMouse extends MickeyMouse{
    public AutumnMickeyMouse(Person person){
        super(person);
    }
    public String toString(){
        return "This is autumn version: " + super.toString();
    }
}
class WinterMickeyMouse extends MickeyMouse{
    public WinterMickeyMouse(Person person){
        super(person);
    }
    public String toString(){
        return "This is winter version: " + super.toString();
    }
}
class HalloweenMickeyMouse extends MickeyMouse{
    public HalloweenMickeyMouse(Person person){
        super(person);
    }
    public String toString(){
        return "This is halloween version: " + super.toString();
    }
}
class ValentineMickeyMouse extends MickeyMouse{
    public ValentineMickeyMouse(Person person){
        super(person);
    }
    public String toString(){
        return "This is valentine version: " + super.toString();
    }
}

class WinnieThePooh extends Mascot{
    private static final String NAME = "Winnie the Pooh";
    private static final double HEIGHT = 1.7;
    private static final double WIDTH = 1.1;
    private static final String APPEARANCE = "yellow bear in red clothes";
    
    public WinnieThePooh(Person person){
        super(WinnieThePooh.NAME, WinnieThePooh.HEIGHT, WinnieThePooh.WIDTH, WinnieThePooh.APPEARANCE, person);
    }
}

class SpringWinnieThePooh extends WinnieThePooh{
    public SpringWinnieThePooh(Person person){
        super(person);
    }
    public String toString(){
        return "This is spring version: " + super.toString();
    }
}
class SummerWinnieThePooh extends WinnieThePooh{
    public SummerWinnieThePooh(Person person){
        super(person);
    }
    public String toString(){
        return "This is summer version: " + super.toString();
    }
}
class AutumnWinnieThePooh extends WinnieThePooh{
    public AutumnWinnieThePooh(Person person){
        super(person);
    }
    public String toString(){
        return "This is autumn version: " + super.toString();
    }
}
class WinterWinnieThePooh extends WinnieThePooh{
    public WinterWinnieThePooh(Person person){
        super(person);
    }
    public String toString(){
        return "This is winter version: " + super.toString();
    }
}
class HalloweenWinnieThePooh extends WinnieThePooh{
    public HalloweenWinnieThePooh(Person person){
        super(person);
    }
    public String toString(){
        return "This is halloween version: " + super.toString();
    }
}
class ValentineWinnieThePooh extends WinnieThePooh{
    public ValentineWinnieThePooh(Person person){
        super(person);
    }
    public String toString(){
        return "This is valentine version: " + super.toString();
    }
}

class Mascots{
    protected Mascot[] mascots;

    public Mascots(Mascot[] mascots){
        this.mascots = mascots;
    }
    public Mascot[] getMascots(){
        return this.mascots;
    }
    public void walkAround(){
        for(Mascot mascot : this.mascots){
            System.out.println(mascot.getName());
        }
        System.out.println("are walking around the fairy world!!");
    }   
}
interface MascotFactory{
    abstract public Mascot createSpringMascot(Person person);
    abstract public Mascot createSummerMascot(Person person);
    abstract public Mascot createAutumnMascot(Person person);
    abstract public Mascot createWinterMascot(Person person);
    abstract public Mascot createHalloweenMascot(Person person);
    abstract public Mascot createValentineMascot(Person person);
}


interface FairyWorldThemeFactory{
    abstract public Poster createPoster();
    abstract public StringOfLights createStringOfLights();
    abstract public LightShow createLightShow();
    abstract public MusicSong createMusicSong();
    abstract public Mascots createMascots(Person[] persons);
}
class SpringThemeFactory implements FairyWorldThemeFactory{
    public Poster createPoster(){
        return new SpringPoster();
    }
    public StringOfLights createStringOfLights(){
        return new SpringStringOfLights();
    }
    public LightShow createLightShow(){
        return new SpringLightShow();
    }
    public MusicSong createMusicSong(){
        return new SpringMusicSong();
    }
    public Mascots createMascots(Person[] persons){
        return new Mascots(new Mascot[]{new SpringMickeyMouse(persons[0]), new SpringWinnieThePooh(persons[1])});
    }
}
class SummerThemeFactory implements FairyWorldThemeFactory{
    public Poster createPoster(){
        return new SummerPoster();
    }
    public StringOfLights createStringOfLights(){
        return new SummerStringOfLights();
    }
    public LightShow createLightShow(){
        return new SummerLightShow();
    }
    public MusicSong createMusicSong(){
        return new SummerMusicSong();
    }
    public Mascots createMascots(Person[] persons){
        return new Mascots(new Mascot[]{new SummerMickeyMouse(persons[0]), new SummerWinnieThePooh(persons[1])});
    }
}
class AutumnThemeFactory implements FairyWorldThemeFactory{
    public Poster createPoster(){
        return new AutumnPoster();
    }
    public StringOfLights createStringOfLights(){
        return new AutumnStringOfLights();
    }
    public LightShow createLightShow(){
        return new AutumnLightShow();
    }
    public MusicSong createMusicSong(){
        return new AutumnMusicSong();
    }
    public Mascots createMascots(Person[] persons){
        return new Mascots(new Mascot[]{new AutumnMickeyMouse(persons[0]), new AutumnWinnieThePooh(persons[1])});
    }
}
class WinterThemeFactory implements FairyWorldThemeFactory{
    public Poster createPoster(){
        return new WinterPoster();
    }
    public StringOfLights createStringOfLights(){
        return new WinterStringOfLights();
    }
    public LightShow createLightShow(){
        return new WinterLightShow();
    }
    public MusicSong createMusicSong(){
        return new WinterMusicSong();
    }
    public Mascots createMascots(Person[] persons){
        return new Mascots(new Mascot[]{new WinterMickeyMouse(persons[0]), new WinterWinnieThePooh(persons[1])});
    }
}
class HalloweenThemeFactory implements FairyWorldThemeFactory{
    public Poster createPoster(){
        return new HalloweenPoster();
    }
    public StringOfLights createStringOfLights(){
        return new HalloweenStringOfLights();
    }
    public LightShow createLightShow(){
        return new HalloweenLightShow();
    }
    public MusicSong createMusicSong(){
        return new HalloweenMusicSong();
    }
    public Mascots createMascots(Person[] persons){
        return new Mascots(new Mascot[]{new HalloweenMickeyMouse(persons[0]), new HalloweenWinnieThePooh(persons[1])});
    }
}
class ValentineThemeFactory implements FairyWorldThemeFactory{
    public Poster createPoster(){
        return new ValentinePoster();
    }
    public StringOfLights createStringOfLights(){
        return new ValentineStringOfLights();
    }
    public LightShow createLightShow(){
        return new ValentineLightShow();
    }
    public MusicSong createMusicSong(){
        return new ValentineMusicSong();
    }
    public Mascots createMascots(Person[] persons){
        return new Mascots(new Mascot[]{new ValentineMickeyMouse(persons[0]), new ValentineWinnieThePooh(persons[1])});
    }
}

class FairyWorld{
    public void demoTheme(FairyWorldThemeFactory factory, Person[] persons){
        String newline = System.lineSeparator();

        System.out.println("The demo of the theme today is starting..." + newline);

        System.out.println(factory.createPoster());
        System.out.println(factory.createStringOfLights());
        System.out.println(factory.createLightShow());
        System.out.println(factory.createMusicSong());
        if(persons.length >= 2){
            Mascots mascots = factory.createMascots(persons);
            for(Mascot mascot : mascots.getMascots()){
                System.out.println(mascot);
            }
        }
        else System.out.println("Short of stuff inside mascot!");

        System.out.println(newline);
    }
}

class Main{
    public static void main(String[] args){
        FairyWorld fairyWorld = new FairyWorld();

        Person lea = new Person("Léa", "Seydoux", 37, 1.68, 53, "female");
        Person matt = new Person("Matt", "Damon", 51, 1.78, 80, "male");
        Person eva = new Person("Eva", "Green", 42, 1.68, 53, "female");

        fairyWorld.demoTheme(new SpringThemeFactory(), new Person[]{lea, matt, eva});
        fairyWorld.demoTheme(new SummerThemeFactory(), new Person[]{lea, matt, eva});
        fairyWorld.demoTheme(new AutumnThemeFactory(), new Person[]{lea, matt, eva});
        fairyWorld.demoTheme(new WinterThemeFactory(), new Person[]{lea, matt, eva});
        fairyWorld.demoTheme(new HalloweenThemeFactory(), new Person[]{lea, matt, eva});
        fairyWorld.demoTheme(new ValentineThemeFactory(), new Person[]{lea, matt, eva});
    }
}
