package org.apidesign.demo.talk2compiler;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public class Main extends RootNode {
    static final CallTarget CODE = Truffle.getRuntime().createCallTarget(new Main());

    public Main() {
        super(null);
    }

    public static void main(String... args) {
        String who = args.length > 0 ? args[0] : "unknown";
        System.err.println(CODE.call(who));
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return String.format("Hello from %s!", frame.getArguments()[0]);
    }
}
