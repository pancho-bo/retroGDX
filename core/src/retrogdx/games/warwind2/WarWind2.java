package retrogdx.games.warwind2;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Tree.Node;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.ui.widget.VisLabel;
import retrogdx.Game;
import retrogdx.games.warwind.WarWind;
import retrogdx.ui.AssetFolderNode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WarWind2 extends WarWind {
    public WarWind2(Table previewArea) {
        super(previewArea, "War Wind 2");
    }

    public boolean parse(FileHandle folder) {
        if (folder.child("WARWIND2.EXE").exists()) {
            this.folder = folder;
            return true;
        }

        return false;
    }

    protected void showPreview() {
        this.previewArea.add(new VisLabel("Preview..."));
    }
}