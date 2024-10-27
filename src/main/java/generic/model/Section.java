package generic.model;

import java.util.LinkedList;
import java.util.List;

public class Section {

    private List<QABlock> blocks;

    public Section() {
        this.blocks = new LinkedList<QABlock>();
    }
    public Section(List<QABlock> blocks) {
        this.blocks = blocks;
    }

    public List<QABlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<QABlock> blocks) {
        this.blocks = blocks;
    }

    public void addBlock(QABlock block) {
        if(block == null) return;
        this.blocks.add(block);
    }

}
