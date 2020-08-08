package prove;

public interface Teleports {
    String teleport();
}

class CanTeleport implements Teleports{
    public String teleport(){
        return "Teleports Away";
    }
}

class CantTeleport implements Teleports{
    public String teleport(){
        return "Fails at Teleporting";
    }
}