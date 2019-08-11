import React, { createRef } from "react";
import List from "../List/List";
import FilterBox from "../FilterBox/FilterBox";
import './MainPage.css'

class MainPage extends React.Component {

    listRef = createRef<List>();

    constructor(props: any){
        super(props);

        this.onFilterChange = this.onFilterChange.bind(this);
    }

    onFilterChange(type: "state" | "country", name: string, value: boolean) {
        if (this.listRef !== null && this.listRef.current !== null) {
            this.listRef.current.onFilterChange(type, name, value);
        }
    }

    render() {
        return (
            <div className="grid">
                <div>
                    <FilterBox onChange={this.onFilterChange} />
                </div>
                <List ref={this.listRef} />
            </div >
        );
    }
}

export default MainPage;