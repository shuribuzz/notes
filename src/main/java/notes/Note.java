package notes;

import java.util.UUID;
import static java.nio.charset.StandardCharsets.*;

public class Note {
    private UUID id;
    private String title;
    private String text;
    private long date_create;
    private long date_update;
    
    private static int limChTitle = 30;
    private static int limChText = 500;

    private Note(NoteBuilder builder){
        this.id = builder.id;
        this.title = builder.title;
        this.text = builder.text;
        this.date_create = builder.date_create;
        this.date_update = builder.date_update;
    }

    public Note(){
        Note not = new Note.NoteBuilder().id().dateCreate().dateUpdate().build();
        this.id = not.getId();
        this.title = not.getTitle();
        this.text = not.getText();
        this.date_create = not.getDateCreate();
        this.date_update = not.getDateUpdate();
    }

    public Note(UUID id, String title, String text, long date_create, long date_update) {
        Note not = new Note.NoteBuilder().id().dateCreate().dateUpdate()
                .title(title)
                .text(text)
                .build();

        this.id = not.getId();
        this.title = not.getTitle();
        this.text = not.getText();
        this.date_create = not.getDateCreate();
        this.date_update = not.getDateUpdate();
    }

    public UUID getId(){
        return this.id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title){
        this.title = title.length() > limChTitle ? title.substring(0, limChTitle) : title;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text){
         this.text = text.length() > limChText ? title.substring(0, limChText) : text;
    }

    public long getDateCreate() {
        return this.date_create;
    }

    public void setDateCreate(long date_create){
        this.date_create = date_create;
    }

    public long getDateUpdate() {
        return this.date_update;
    }

    public void setDateUpdate(long date_update){
        this.date_update = date_update;
    }

    public static class NoteBuilder{
        private UUID id;
        private String title = "";
        private String text = "";
        private long date_create;
        private long date_update;

        public NoteBuilder id(){
            this.id =  UUID.randomUUID();
            return this;
        }

        public NoteBuilder title(String title){
            this.title = title.length() > limChTitle ? title.substring(0, limChTitle) : title;
            return this;
        }

        public NoteBuilder text(String text){
            this.text = text.length() > limChText ? title.substring(0, limChText) : text;
            return this;
        }

        public NoteBuilder dateCreate() {
            this.date_create = System.currentTimeMillis() / 1000L;
            return this;
        }

        public NoteBuilder dateUpdate(){
            this.date_update = System.currentTimeMillis() / 1000L;
            return this;
        }

        public Note build(){
            return new Note(this);
        }
    }
}
