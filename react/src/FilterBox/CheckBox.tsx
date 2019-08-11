import React from "react";

interface IProps {
    label: String,
    onChange: (name: string, value: boolean) => void
}

class CheckBox extends React.Component<IProps> {

    constructor(props: IProps) {
        super(props);

        this.onChange = this.onChange.bind(this);
    }

    onChange(event: React.ChangeEvent<HTMLInputElement>) {
        if (event !== null && event !== undefined && event.target !== null) {
            this.props.onChange(this.props.label.replace(" ", "").toLowerCase(), event.target.checked);
        }
    }

    render() {
        return (
            <div>
                <input type="checkbox" onChange={this.onChange} />
                <label>{this.props.label}</label>
            </div>
        );
    }
}

export default CheckBox;