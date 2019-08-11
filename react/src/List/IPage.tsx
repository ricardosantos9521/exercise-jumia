import { ICustomer } from "../Customer/ICustomer";

export interface IPage {
    page: number;
    numberPages: number;
    listCustomers: Array<ICustomer>
}