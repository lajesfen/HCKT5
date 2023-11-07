import React, { useEffect, useState } from 'react';
import axios from 'axios';
import 'devextreme/data/odata/store';
import DataGrid, {
  Column
} from 'devextreme-react/data-grid';

export default function GrupoTipo() {
  const [data, setData] = useState([]);

  const getApi = async () => {
    const res = await axios.get(`http://localhost:8080/grupotipos`);

    setData(res.data);
  }

  useEffect(() => {
    getApi();
  }, [])

  return (
    <React.Fragment>
      <h2 className={'content-block'}>GrupoTipo</h2>

      <DataGrid
        id="dataGrid"
        dataSource={data}
        keyExpr="id"
        className={'dx-card wide-card'}
        showBorders={false}
        focusedRowEnabled={true}
        defaultFocusedRowIndex={0}
        columnAutoWidth={true}
        columnHidingEnabled={true}>

        <Column dataField={'id'} width={90} />
        <Column
          dataField={'name'}
          width={360}
          caption={'Nombre'}
        />

      </DataGrid>

      
    </React.Fragment>
  )
}
