import React from "react";
import { ICustomer } from "../Customer/ICustomer";
import Config from "../Config";
import Customer from "../Customer/Customer";
import { IPage } from "./IPage";
import './List.css';

interface IState {
    customers: Array<ICustomer> | null
}

class List extends React.Component<any, IState> {

    currentPage: number = 1;
    numberPages: number = 0;

    filterStates: Array<String> = [];
    filterCountries: Array<String> = [];

    constructor(props: any) {
        super(props);

        this.state = {
            customers: null
        }

        this.getCustomers = this.getCustomers.bind(this);
        this.onFilterChange = this.onFilterChange.bind(this);
        this.goBackOnePage = this.goBackOnePage.bind(this);
        this.goNextOnePage = this.goNextOnePage.bind(this);
    }

    async componentDidMount() {
        this.getCustomers();
    }

    async getCustomers() {
        var url = Config.urlApi + "/customers?";
        url += `page=${this.currentPage}&`;

        if (this.filterStates.length > 0) {
            url += `states=${this.filterStates.join(",")}&`;
        }

        if (this.filterCountries.length > 0) {
            url += `countries=${this.filterCountries.join(",")}&`;
        }

        var response = await fetch(url);

        if (response.ok) {
            var page: IPage = JSON.parse(await response.text()) as IPage;
            this.currentPage = page.page;
            this.numberPages = page.numberPages;
            this.setState({ customers: page.listCustomers });
        }
    }

    onFilterChange(type: "state" | "country", name: string, value: boolean) {
        if (type === "state") {
            if (!value) {
                let index = this.filterStates.indexOf(name);
                if (index >= 0) {
                    this.filterStates.splice(index, 1);
                }
            }
            else {
                this.filterStates.push(name);
            }
        }
        else if (type === "country") {
            if (!value) {
                let index = this.filterCountries.indexOf(name);
                if (index >= 0) {
                    this.filterCountries.splice(index, 1);
                }
            }
            else {
                this.filterCountries.push(name);
            }
        }

        this.getCustomers();
    }

    async goBackOnePage() {
        this.currentPage--;
        await this.getCustomers();
    }

    async goNextOnePage() {
        this.currentPage++;
        await this.getCustomers();
    }

    render() {
        if (this.state.customers === null) {
            return (
                <p>Obtaining Customers</p>
            )
        }
        else {
            return (
                <div>
                    <table className="list">
                        <tbody>
                            <tr>
                                <td>ID</td>
                                <td>Name</td>
                                <td>Country</td>
                                <td>Country Code</td>
                                <td>Number</td>
                                <td>State</td>
                            </tr>
                        </tbody>
                        {
                            this.state.customers.map((c, k) => {
                                return (
                                    <Customer customer={c} key={k} />
                                )
                            })
                        }
                    </table>
                    <div className="pagination">
                        <input className={(this.currentPage <= 1) ? "hidden" : ""} type="button" value="Back" onClick={this.goBackOnePage} />
                        <label>{this.currentPage}</label>
                        <input className={(this.numberPages <= this.currentPage) ? "hidden" : ""} type="button" value="Next" onClick={this.goNextOnePage} />
                    </div>
                </div>
            );
        }

    }
}

export default List;