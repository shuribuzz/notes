package notes;

import java.util.concurrent.CopyOnWriteArrayList;

public class NoteList {
    private static final CopyOnWriteArrayList<Note> nList = new CopyOnWriteArrayList<>();

    static {
        nList.add(
                new Note.NoteBuilder().id().dateCreate().dateUpdate()
                        .title("1 заметка")
                        .text("Текст первой заметки")
                        .build()
        );

        nList.add(
                new Note.NoteBuilder().id().dateCreate().dateUpdate()
                        .title("2 заметка")
                        .text("Текст второй заметки")
                        .build()
        );
    }
    private NoteList() {
    }

    public static CopyOnWriteArrayList<Note> getInstance(){
            return nList;
        }
}
