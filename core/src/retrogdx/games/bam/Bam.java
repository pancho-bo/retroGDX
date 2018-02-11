package retrogdx.games.bam;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Tree.Node;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.ui.widget.VisLabel;
import retrogdx.Game;
import retrogdx.games.bam.nodes.StfNode;
import retrogdx.ui.AssetFolderNode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Bam extends AssetFolderNode implements Game {
    private FileHandle folder;

    public Bam(Table previewArea) {
        super(previewArea, "Blood & Magic");
    }

    public boolean parse(FileHandle folder) {
        if (folder.child("BAMMAIN.EXE").exists()) {
            this.folder = folder;
            return true;
        }

        return false;
    }

    protected Array<Node> populate() {
        Map<String, Node> files = new HashMap<>();

        for (FileHandle file : this.folder.list()) {
            if (file.extension().equals("STF")) {
                files.put(file.name(), new StfNode(this.previewArea, file));
            }
        }

        Map<String, Node> sorted = new TreeMap<>(files);
        Array<Node> result = new Array<>();

        for (String key : sorted.keySet()) {
            result.add(files.get(key));
        }

        return result;
    }

    protected void showPreview() {
        this.previewArea.add(new VisLabel("Preview..."));
    }
}