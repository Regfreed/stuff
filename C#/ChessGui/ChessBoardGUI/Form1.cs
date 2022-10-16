using System;
using ChessBoardModel;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChessBoardGUI
{
    public partial class Form1 : Form
    {
        private Board myBoard;

        public Form1()
        {
            InitializeComponent();
            comboBox1.SelectedIndexChanged += ComboBox1_SelectedIndexChanged;
            
           

        }

        protected override void OnLoad(EventArgs e)
        {
            base.OnLoad(e);
        }

        private void ComboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            var combo = (ComboBox) sender;

           // myBoard = new Board(combo.SelectedItem);
        }
    }
}
