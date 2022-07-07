package org.coderead.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PlayTypeTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void raise_exception_with_unknown_type() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid type: not-exist-type.");

        PlayType.of("not-exist-type");
    }
}