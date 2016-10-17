package com.jasrsir.dinamictable;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * @author Juan Antonio Suarez Rosa
 * @version 1.0
 *  Exercise that show to create components at runtime.
 *  - Resources used:
 *      - LayoutParams
 *      - TableRow
 *      - shapes
 *      - array-Strings
 *      - Colors in TableRow
 */
public class DinamicTable_Activity extends AppCompatActivity {

    //region Variables de clase
    private TableLayout mTblHeader;
    private TableLayout mTblBody;
    private TableRow.LayoutParams mTbrLayoutId;
    private TableRow.LayoutParams mTbrLayoutName;
    private TableRow.LayoutParams mTbrLayout;
    //enregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamic_table);

        inicializar();
    }

    //Initialization variables
    private void inicializar() {
        //Variable Inicialization
        mTblHeader = (TableLayout) findViewById(R.id.tblHeader);
        mTblBody = (TableLayout) findViewById(R.id.tblBody);
        //
        mTbrLayoutId = new TableRow.LayoutParams(100, TableRow.LayoutParams.WRAP_CONTENT);
        mTbrLayoutId.setMargins(10,20,10,20);
        mTbrLayoutName = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        mTbrLayoutName.setMargins(10,20,10,20);
        mTbrLayout = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
        createHeader();
        createdBody();
    }

    //TableHead Creation
    private void createHeader() {
        TableRow mTbrHeader = new TableRow(this);     //Header Created
        TextView mTxvId = new TextView(this);         //TextView Id created
        mTxvId.setText(R.string.txvId);
        mTxvId.setLayoutParams(mTbrLayoutId);
        mTxvId.setBackgroundResource(R.drawable.shape_header);
        mTbrHeader.addView(mTxvId);                   //Add TextView into TableRow Header

        TextView mTxvName = new TextView(this);       //TextView Nombre created
        mTxvName.setText(R.string.txvName);
        mTxvName.setLayoutParams(mTbrLayoutName);
        mTxvName.setBackgroundResource(R.drawable.shape_header);
        mTbrHeader.addView(mTxvName);                 //Add TextView into TableRow Header

        mTblHeader.addView(mTbrHeader);               //Add TableRow into TableLayout
    }

    //TableBody Creation
    private void createdBody() {
        TableRow mTbrBody;   //Creamos el Cuerpo
        TextView mTxvId;       //TextView Id created
        TextView mTxvName;    //TextView Name created
        String[] listName = getResources().getStringArray(R.array.listName);
        for (int i = 0; i < listName.length; i++) {
            mTbrBody = new TableRow(this);

            mTxvId = new TextView(this);
            mTxvId.setText(" " + (i+1) + " ");
            mTxvId.setLayoutParams(mTbrLayoutId);
            mTxvId.setBackgroundResource(R.drawable.shape_body);

            mTxvName = new TextView(this);
            mTxvName.setText(listName[i]);
            mTxvName.setLayoutParams(mTbrLayoutName);
            mTxvName.setBackgroundResource(R.drawable.shape_body);
            //
            mTbrBody.addView(mTxvId);
            mTbrBody.addView(mTxvName);
            mTblBody.addView(mTbrBody);
        }
    }
}

//TableLayout
    //TableRow
        //TextViewId
        //TextViewName