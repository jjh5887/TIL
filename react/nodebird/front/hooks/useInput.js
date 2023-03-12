import { useCallback, useState } from "react";

export default (initValue) => {
    const [value, setValue] = useState(initValue);
    const handler = useCallback((e) => {
        setValue(e.target.value);
    }, []);
    return [value, handler];
}