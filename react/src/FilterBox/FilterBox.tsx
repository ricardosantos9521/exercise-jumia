import React from "react";
import CheckBox from "./CheckBox";
import Config from "../Config";
import './FilterBox.css'

interface IProps {
    onChange: (type: "state" | "country", name: string, value: boolean) => void
}

interface IState {
    countries: Array<String> | null
}


class FilterBox extends React.Component<IProps, IState> {

    constructor(props: IProps) {
        super(props);

        this.state = {
            countries: null
        }

        this.getCountries = this.getCountries.bind(this);
        this.onChangeCountry = this.onChangeCountry.bind(this);
        this.onChangeState = this.onChangeState.bind(this);
    }

    async componentDidMount() {
        await this.getCountries();
    }

    async getCountries() {
        var response = await fetch(Config.urlApi + "/countries");

        if (response.ok) {
            var countries: Array<String> = JSON.parse(await response.text()) as Array<String>;
            this.setState({ countries });
        }
    }

    onChangeCountry(name: string, value: boolean) {
        this.props.onChange("country", name, value);
    }

    onChangeState(name: string, value: boolean) {
        this.props.onChange("state", name, value);
    }

    render() {
        return (
            <div className="filterBox">
                <p>Filter:</p>
                <div>
                    <p>Countries:</p>
                    {
                        (this.state.countries === null) ?
                            <p>Obtaining Countries...</p> :
                            this.state.countries.map((c, k) => {
                                return (
                                    <CheckBox label={c} key={k} onChange={this.onChangeCountry} />
                                )
                            })
                    }
                </div>
                <div>
                    <p>State:</p>
                    <CheckBox label="Valid" onChange={this.onChangeState} />
                    <CheckBox label="Not Valid" onChange={this.onChangeState} />
                </div>
            </div>
        );
    }
}

export default FilterBox;