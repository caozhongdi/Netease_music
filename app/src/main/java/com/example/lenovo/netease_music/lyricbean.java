package com.example.lenovo.netease_music;

/**
 * Created by lenovo on 2018/12/14.
 */

public class lyricbean {

    /**
     * sgc : true
     * sfy : false
     * qfy : false
     * lrc : {"version":4,"lyric":"作曲 : prod by ASAP Rocky Type Beat\n作词 : G2C\nMIXED BY N.SHIRMP\n我们简直太烫手 观众举起telescope\n我们的任务就是每天对着镜头say hello\n不要再说了 你的破绽太多了\n不想继续再拖着 马上把你给做了\nay\n天才都被当成神经病\nay\n多的让我数不清\nay\n太多的事情 还不能适应\n太多的烦恼让我把自己给泡进了酒精\nasian军团in the building\n是多么幸运的 每天都在归零着\n拒绝接受命令的 一直保持清醒呢\n跟我兄弟穿过黑暗走进了黎明\n我们正在尝试不断创新成功的情形\niphonexringring着\n浑身上下blingbling\n那些loser庆幸这\n发动机都vroom vroom呢\n\n为了面子做音乐？？\n一个二个都在秀其实非常瓜\nhomee远离他 知道你在哪\n我在上海的studio录音可是你却只能在这玩泥巴\n想说的话没说完兄弟兄弟在这woo\n情人节还没到就给我gf挑礼物\n懂不起的我就只能劝你多读点书\n下个月就从香港香港飞到马里布\n从不信上天的设置 我们还在这坚持 \n有时会变得很偏执 保持锋利的特征\n这是我走过的路 现在还你挑个方式输\n再见\n"}
     * klyric : {"version":0,"lyric":null}
     * tlyric : {"version":0,"lyric":null}
     * code : 200
     */

    private boolean sgc;
    private boolean sfy;
    private boolean qfy;
    private LrcBean lrc;
    private KlyricBean klyric;
    private TlyricBean tlyric;
    private int code;

    public boolean isSgc() {
        return sgc;
    }

    public void setSgc(boolean sgc) {
        this.sgc = sgc;
    }

    public boolean isSfy() {
        return sfy;
    }

    public void setSfy(boolean sfy) {
        this.sfy = sfy;
    }

    public boolean isQfy() {
        return qfy;
    }

    public void setQfy(boolean qfy) {
        this.qfy = qfy;
    }

    public LrcBean getLrc() {
        return lrc;
    }

    public void setLrc(LrcBean lrc) {
        this.lrc = lrc;
    }

    public KlyricBean getKlyric() {
        return klyric;
    }

    public void setKlyric(KlyricBean klyric) {
        this.klyric = klyric;
    }

    public TlyricBean getTlyric() {
        return tlyric;
    }

    public void setTlyric(TlyricBean tlyric) {
        this.tlyric = tlyric;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class LrcBean {
        /**
         * version : 4
         * lyric : 作曲 : prod by ASAP Rocky Type Beat
         作词 : G2C
         MIXED BY N.SHIRMP
         我们简直太烫手 观众举起telescope
         我们的任务就是每天对着镜头say hello
         不要再说了 你的破绽太多了
         不想继续再拖着 马上把你给做了
         ay
         天才都被当成神经病
         ay
         多的让我数不清
         ay
         太多的事情 还不能适应
         太多的烦恼让我把自己给泡进了酒精
         asian军团in the building
         是多么幸运的 每天都在归零着
         拒绝接受命令的 一直保持清醒呢
         跟我兄弟穿过黑暗走进了黎明
         我们正在尝试不断创新成功的情形
         iphonexringring着
         浑身上下blingbling
         那些loser庆幸这
         发动机都vroom vroom呢

         为了面子做音乐？？
         一个二个都在秀其实非常瓜
         homee远离他 知道你在哪
         我在上海的studio录音可是你却只能在这玩泥巴
         想说的话没说完兄弟兄弟在这woo
         情人节还没到就给我gf挑礼物
         懂不起的我就只能劝你多读点书
         下个月就从香港香港飞到马里布
         从不信上天的设置 我们还在这坚持
         有时会变得很偏执 保持锋利的特征
         这是我走过的路 现在还你挑个方式输
         再见

         */

        private int version;
        private String lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
    }

    public static class KlyricBean {
        /**
         * version : 0
         * lyric : null
         */

        private int version;
        private Object lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public Object getLyric() {
            return lyric;
        }

        public void setLyric(Object lyric) {
            this.lyric = lyric;
        }
    }

    public static class TlyricBean {
        /**
         * version : 0
         * lyric : null
         */

        private int version;
        private Object lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public Object getLyric() {
            return lyric;
        }

        public void setLyric(Object lyric) {
            this.lyric = lyric;
        }
    }
}
